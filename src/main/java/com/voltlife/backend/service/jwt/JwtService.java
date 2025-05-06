package com.voltlife.backend.service.jwt;

import com.voltlife.backend.model.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        long expiry = 10800L;
        var role = user.getRole();

        var claims = JwtClaimsSet.builder()
                .issuer("jwt")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .id(user.getId().toString())
                .subject(user.getEmail())
                .claim("role", role)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}