package com.nami;

import com.nami.model.User;
import com.nami.service.UserService;

/**
 * 简易服务消费者示例
 * @author nami404
 * * @date 2024/6/25 16:49
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // todo 需要获取UserService 的实现对象
        UserService userService = null;
        User user = new User();
        user.setName("nami404");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}