package com.hy.think.net.vert;

import io.vertx.core.Vertx;

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

    }

}

