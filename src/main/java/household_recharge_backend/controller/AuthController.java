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

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(
            UserService userService,
            JwtService jwtService
    ) {
        this.userService = userService;
        this.jwtService = jwtService;
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
            String accessToken = jwtService.generateToken(user);

            LoginResponse response = new LoginResponse(
                    accessToken,
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
}