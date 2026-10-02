package household_recharge_backend.service;

import household_recharge_backend.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "mySuperSecretKeyForHouseholdRechargeApplication2026SecureKey";

    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24; // 24 hours

    private final SecretKey key = Keys.hmacShaKeyFor(
            SECRET_KEY.getBytes(StandardCharsets.UTF_8)
    );

    public String generateToken(User user) {

        return Jwts.builder()
                .subject(user.getId())
                .claim("mobileNumber", user.getMobileNumber())
                .claim("name", user.getName())
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + EXPIRATION_TIME
                ))
                .signWith(key)
                .compact();
    }

    public String extractUserId(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean isTokenValid(String token) {

        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}