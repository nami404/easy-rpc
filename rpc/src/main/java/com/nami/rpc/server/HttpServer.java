package com.nami.rpc.server;

/**
 * HTTP 服务器接口
 *
 * @author nami404
 * * @date 2024/6/25 16:56
 */
public interface HttpServer {
    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}
