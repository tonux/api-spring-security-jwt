package com.sn.atos.atosspringsecurityjwt.config;

import com.sn.atos.atosspringsecurityjwt.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String jwtSecret= "zdtlD3JK56m6wTTgsNFhqzjqP";
    private final String jwtIssuer= "atos.io";


    public String generateAccessToken(User user){
        return Jwts.builder()
                .setSubject(user.getId()+","+user.getUsername() )
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 semaine
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public String getUsername(String token){
        Claims claims = getClaims(token);

        return claims.getSubject().split(",")[1];
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
    }

    public Date getExpirationDate(String token){
        Claims claims = getClaims(token);

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature - "+ ex.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token - "+ ex.getMessage());
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token - "+ ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token - "+ ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty - "+ ex.getMessage());
        }
        return false;
    }
}
