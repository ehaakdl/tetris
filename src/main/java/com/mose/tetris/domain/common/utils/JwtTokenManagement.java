package com.mose.tetris.domain.common.utils;

import io.jsonwebtoken.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;



@Configuration
@PropertySource("classpath:application-privacy.properties")
public class JwtTokenManagement {
    @Value("${jwt.encrypt.key}")
    private String SECRETKEY;

    private final Key KEY;

    public init() {
        byte[] secretKeyBytes = SECRETKEY.getBytes(StandardCharsets.UTF_8);
        String jcaName = SignatureAlgorithm.HS256.getJcaName();
        KEY = new SecretKeySpec(secretKeyBytes, jcaName);
    }

    public String create(Date expireDate, Map<String, Object> header, Map<String, Object> claims) {
        if(expireDate == null || header == null || claims == null){
            return null;
        }
        JwtBuilder builder = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, KEY);
        return builder.compact();
    }

    public boolean isVerify(String token) {
        boolean bResult = true;
        try {
            Jwts.parser()
                    .setSigningKey(SECRETKEY.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException except) {
            bResult = true;
        } catch (Exception except) {
            bResult = false;
        }
        return bResult;
    }

    public Map<String, Object> getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRETKEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException except) {
            return null;
        } catch (Exception except) {
            return null;
        }
        return claims;
    }

}
