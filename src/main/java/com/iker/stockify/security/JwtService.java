package com.iker.stockify.security;

import com.iker.stockify.entities.Empleado;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey signingKey = Jwts.SIG.HS256.key().build();
    private final long expiration = 86400000;

    public String generateToken(Empleado empleado) {
        Date now = new Date();
        return Jwts.builder()
                .subject(empleado.getUsuario())
                .claim("role", empleado.getRole().toString())
                .issuedAt(now)
                .expiration(new Date(now.getTime() + expiration))
                .signWith(signingKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            extractUsername(token);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
