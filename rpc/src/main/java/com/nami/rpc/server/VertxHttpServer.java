package com.nami.rpc.server;


import io.vertx.core.Vertx;

/**
 * @author nami404
 * * @date 2024/6/25 16:56
 */
public class VertxHttpServer implements HttpServer{
    /**
     * 启动服务器
     *
     * @param port
     */
    public void doStart(int port) {
        // 创建 Vert.x 实例
        Vertx vertx = Vertx.vertx();

        // 创建 HTTP 服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 处理请求
        server.requestHandler(new HttpServerHandler());

        //启动 HTTP 服务器并监听指定端口
        server.listen(port, httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()) {
                System.out.println("Server is now listening on port " + port);
            } else {
                System.out.println("Failed to start server: " + httpServerAsyncResult.cause());
            }
        });
    }
}
