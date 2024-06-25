package com.nami;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.nami.model.User;
import com.nami.rpc.model.RpcRequest;
import com.nami.rpc.model.RpcResponse;
import com.nami.rpc.serializer.JdkSerializer;
import com.nami.service.UserService;

import java.io.IOException;

/**
 * 静态代理
 *
 * @author nami404
 * * @date 2024/6/25 18:32
 */
public class UserServiceProxy implements UserService {
    public User getUser(User user) {
        // 指定序列化器
        JdkSerializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterType(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
