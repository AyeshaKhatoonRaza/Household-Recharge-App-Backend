package household_recharge_backend.service;

import household_recharge_backend.dto.SignupRequest;
import household_recharge_backend.model.User;
import household_recharge_backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignupRequest request) {

        // Check if mobile number already exists
        if (userRepository.existsByMobileNumber(request.getMobileNumber())) {
            throw new RuntimeException("Mobile number already registered");
        }

        // Encrypt password
        String encryptedPassword =
                passwordEncoder.encode(request.getPassword());

        // Create user
        User user = new User(
                request.getName(),
                request.getMobileNumber(),
                encryptedPassword
        );

        // Save user in MongoDB
        return userRepository.save(user);
    }

    public User login(String mobileNumber, String password) {

        // Find user by mobile number
        User user = userRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // Check password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    public User getUserById(String userId) {

        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
}