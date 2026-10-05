package household_recharge_backend.controller;

import household_recharge_backend.dto.SignupRequest;
import household_recharge_backend.dto.SignupResponse;
import household_recharge_backend.model.User;
import household_recharge_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import household_recharge_backend.dto.LoginRequest;
import household_recharge_backend.dto.LoginResponse;
import household_recharge_backend.service.JwtService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import household_recharge_backend.service.RefreshTokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public AuthController(
            UserService userService,
            JwtService jwtService,
            RefreshTokenService refreshTokenService
    ) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {

        try {
            User user = userService.signup(request);

            SignupResponse response = new SignupResponse(
                    user.getId(),
                    user.getName(),
                    user.getMobileNumber()
            );

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        try {
            User user = userService.login(
                    request.getMobileNumber(),
                    request.getPassword()
            );

            // Generate JWT token
            String accessToken =
                    jwtService.generateAccessToken(user);

            String refreshToken =
                    refreshTokenService.createRefreshToken(
                            user.getId()
                    );

            LoginResponse response = new LoginResponse(
                    accessToken,
                    refreshToken,
                    user.getId(),
                    user.getName(),
                    user.getMobileNumber()
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(
            @AuthenticationPrincipal String userId
    ) {

        try {
            User user = userService.getUserById(userId);

            SignupResponse response = new SignupResponse(
                    user.getId(),
                    user.getName(),
                    user.getMobileNumber()
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(
            @RequestBody RefreshRequest request
    ) {

        try {

            String userId =
                    refreshTokenService.validateAndGetUserId(
                            request.getRefreshToken()
                    );

            User user =
                    userService.getUserById(userId);

            String newAccessToken =
                    jwtService.generateAccessToken(user);

            return ResponseEntity.ok(
                    new RefreshResponse(newAccessToken)
            );

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    public static class RefreshRequest {

        private String refreshToken;

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }

    public static class RefreshResponse {

        private String accessToken;

        public RefreshResponse(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getAccessToken() {
            return accessToken;
        }
    }
}