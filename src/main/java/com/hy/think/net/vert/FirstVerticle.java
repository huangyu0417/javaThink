package com.hy.think.net.vert;

import io.vertx.core.AbstractVerticle;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/12/26 17:13
 */
public class FirstVerticle extends AbstractVerticle{
    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            System.out.println(req.uri());
            System.out.println(req.absoluteURI());
            req.response()
                    .putHeader("content-type","text/html")
                    .end("<h>Hello world!</h>");
        }).listen(8831);
    }
}
