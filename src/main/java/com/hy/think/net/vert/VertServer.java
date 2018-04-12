package com.hy.think.net.vert;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/12/26 16:03
 */
public class VertServer {
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(FirstVerticle.class.getName(),event -> System.out.println(event.succeeded()));
        web();
    }

    static void web() {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route().handler(event -> {
            HttpServerResponse response = event.response();
            response.putHeader("content-type","text/plain");
            response.end("<h1>First Deal</h1>");
        });
        server.requestHandler(router::accept).listen(8832);
    }

}

