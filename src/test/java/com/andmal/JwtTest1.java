package com.andmal;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;

public class JwtTest1 {
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Test
    void checkJwt() {
        String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbmRyaWkifQ.hIE7K2wplrDOzA7Bquu4PjJIptlfx1XqS1ypKppogPA";
        try {
            Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(jws).getBody().getSubject().equals("Petro");
        } catch (JwtException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createJwt() {
        try {
            final String KEY = "aasd87sdfhkh7uhfksdflhnfhfhwirfhnisbul7hdsssfv";
            String header = "{\"alg\":\"HS256\"}";
            String claims = "{\"sub\":\"Petro\"}";
            String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes("UTF-8"));
            String encodedClaims = Base64.getEncoder().encodeToString(claims.getBytes("UTF-8"));
            String concat = encodedHeader + "." + encodedClaims;
//            byte[] signature = hmacSha256(concat, key);
            byte[] signature = Keys.hmacShaKeyFor(KEY.getBytes()).getEncoded();
            String jws = concat + '.' + Base64.getEncoder().encodeToString(signature);

            System.out.println(jws);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkKeyOne() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(key);
        System.out.println(key.getAlgorithm());
        System.out.println(key.getEncoded());
        System.out.println(key.getFormat());
    }
}
