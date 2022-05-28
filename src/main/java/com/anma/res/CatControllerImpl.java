package com.anma.res;

import io.javalin.http.Context;

import java.util.List;

public class CatControllerImpl implements CatController {
    @Override
    public void getCats(Context context) {
        context.attribute("cats", List.of("some cat here"));
        context.render("templates/cats.html");
    }

    @Override
    public void getByName(Context context) {
        int name = Integer.parseInt(context.pathParam("name"));
        context.attribute("cat", "Cat with name " + name);
        context.render("templates/cat.html");
    }
}
