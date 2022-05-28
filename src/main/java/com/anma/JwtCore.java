package com.anma;

import com.anma.res.CatController;
import com.anma.res.CatControllerImpl;
import io.javalin.Javalin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static io.javalin.apibuilder.ApiBuilder.*;
public class JwtCore {
    public static void main(String[] args) {

        CatController catController = new CatControllerImpl();

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwt1 = Jwts.builder()
                .setSubject("Petro")
                .setAudience("leute")
                .setExpiration(Date.from(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.UTC)))
                .setHeaderParam("kid", "12345")
                .signWith(key)
                .compact();

        System.out.println(jwt1);

        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx ->
                ctx.header("JWT", jwt1)
                        .status(200)
                        .result("Hello World"));
        app.routes(() -> {
           path("cats", () -> {
               get(catController::getCats);
               path("{name}", () -> {
                   get(catController::getByName);
               });
           });
        });
    }
}
