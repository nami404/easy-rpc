package com.nami.provider;

import com.nami.rpc.registry.LocalRegistry;
import com.nami.rpc.server.HttpServer;
import com.nami.rpc.server.VertxHttpServer;
import com.nami.service.UserService;

/**
 * 简易服务提供者示例
 *
 * @author nami404
 * * @date 2024/6/25 16:38
 */
public class ProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
