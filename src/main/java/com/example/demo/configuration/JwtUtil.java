package com.example.demo.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class JwtUtil {

    static void addAuthentication(HttpServletResponse res, String userName) {

        String token = Jwts.builder()
                .setSubject(userName)
                .signWith(SignatureAlgorithm.HS512, "P@tito")
                .compact();

        res.addHeader("Authorization", "Bearer" + token);

    }


    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Autorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey("P@tito")
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
                    null;
        }
        return null;
    }
}
