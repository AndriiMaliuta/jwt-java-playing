package com.anma.res;

import io.javalin.http.Context;

public interface CatController {
    public void getCats(Context context);

    void getByName(Context context);
}
