package com.phonecontacts.security;

import com.phonecontacts.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${spring.security.secretJwt}")
    private String secretKey;

    @Value("${spring.security.issuerToken}")
    private String issuer;

    //ACCESS TOKEN
    public String generateAccessToken(final User user) {
        final Map<String, Long> claimsMap = new HashMap<>();
        claimsMap.put("uid", user.getId());
        return createToken(claimsMap, user.getEmail());
    }

    private String createToken(final Map<String, Long> claimsMap,
                               final String subject) {
        Instant now = Instant.now();
        //token expire time 15 minute
        Instant expirationTime =
                now.plus(15,
                        ChronoUnit.MINUTES);
        return Jwts
                .builder()
                .setClaims(claimsMap)
                .setSubject(subject)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expirationTime))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .setIssuer(issuer)
                .compact();
    }

    //VALID TOKEN
    public boolean validToken(final UserDto userDto,
                              final String token) {
        final String email = extractClaim(token, Claims::getSubject);
        return (email.equals(userDto.getUsername()) && !expireToken(token));
    }

    private boolean expireToken(final String token) {
        final Date expirationDate = extractClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    //GET USER ID
    public UUID prepareTokenWithUser(final String token) {
        final String accessTokenForUserId = token.split(" ")[1].trim();
        return extractUserId(accessTokenForUserId);
    }

    private UUID extractUserId(final String token) {
        return extractClaim(token, claims ->
                UUID.fromString((String) claims.get("uid")));
    }

    //GET EMAIL
    public String extractEmail(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(final String token,
                               final Function<Claims, T> functionResolver) {
        final Claims claims = extractAllClaims(token);
        return functionResolver.apply(claims);
    }

    private Claims extractAllClaims(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        final byte[] keyByte = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
