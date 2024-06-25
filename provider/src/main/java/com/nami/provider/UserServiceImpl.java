package com.nami.provider;

import com.nami.model.User;
import com.nami.service.UserService;

/**
 * 用户服务实现类
 *
 * @author nami404
 * * @date 2024/6/25 16:30
 */
public class UserServiceImpl implements UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
