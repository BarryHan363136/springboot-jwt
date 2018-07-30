package com.bmw.azure.jwt.config;

import com.bmw.azure.jwt.common.utils.Contants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    static final String SECRET = "ThisIsASecret";

    public static String generateToken(String username) {
        HashMap<String, Object> map = new HashMap<>();
        /** you can put any data in the map */
        /** jwt前面一般都会加Bearer */
        map.put("username", username);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(Contants.EXPIRATION_TIME)))//EXPIRE_TIME失效时间
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer "+jwt;
    }

    public static void validateToken(String token) {
        try {
            /** parse the token */
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ",""))
                    .getBody();
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
    }
}