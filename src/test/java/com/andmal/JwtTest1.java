package com.andmal;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

public class JwtTest1 {
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512

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
            Properties props = new Properties();
            props.load(Files.newInputStream(Path.of("src/main/resources/app.properties")));

            final String KEY = props.getProperty("JWT.secret");
            String header = "{\"alg\":\"HS256\"}";
            String claims = "{\"sub\":\"Petro\"}";
            String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes("UTF-8"));
            String encodedClaims = Base64.getEncoder().encodeToString(claims.getBytes("UTF-8"));
            String concat = encodedHeader + "." + encodedClaims;
//            byte[] signature = hmacSha256(concat, key);
            byte[] signature = Keys.hmacShaKeyFor(KEY.getBytes()).getEncoded();
            String jws = concat + '.' + Encoders.BASE64.encode(signature);

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

    @Test
    void checkKeyPair() {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
        System.out.println(keyPair);

    }


}
