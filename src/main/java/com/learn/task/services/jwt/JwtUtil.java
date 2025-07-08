package com.learn.task.services.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Utility class for generating and validating JWT tokens.
 */
@Component
public class JwtUtil {
    private final JwtProperties jwtProperties;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    // Constructor dependency injection of JWT configuration (secret key & expiration)
    public JwtUtil(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    /**
     * Generate a JWT token using default claims.
     *
     * @param userDetails the authenticated user
     * @return a signed JWT token
     */
    public String generateToken(UserDetails userDetails) {
        return generateTokenWithClaims(new HashMap<>(), userDetails);
    }

    /**
     * Generate JWT token with additional claims.
     *
     * @param extraClaims custom claims (payload data)
     * @param userDetails the authenticated user
     * @return a signed JWT token
     */
    public String generateTokenWithClaims(Map<String, Object> extraClaims,
            UserDetails userDetails) {
        try {
            return Jwts.builder().setClaims(extraClaims) // optional payload
                    .setSubject(userDetails.getUsername()) // subject = username
                    .setIssuedAt(new Date(System.currentTimeMillis())) // issue time
                    .setExpiration(
                            new Date(System.currentTimeMillis() + jwtProperties.getExpirationMs()))
                    .signWith(getSigningKey(), SignatureAlgorithm.HS256) // sign with key
                    .compact(); // build token
        } catch (Exception e) {
            logger.error("Error generating JWT token", e);
            throw new RuntimeException("JWT token creation failed", e);
        }
    }

    /**
     * Converts Base64 secret into a Key object for signing.
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Validate token by checking: - if username in token matches userDetails - if token has not
     * expired
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * Extract the username (subject) from token.
     */
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Generic method to extract any claim using a resolver function.
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    /**
     * Extract all claims from token (used internally).
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    /**
     * Check if token is expired.
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Get expiration date from token.
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
