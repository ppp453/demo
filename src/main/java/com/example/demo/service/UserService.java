package com.example.demo.service;

import com.example.demo.domain.TbUser;

public interface UserService {
    /**
     * 通过用户id获取用户
     *
     * @param uid
     * @return
     */
    TbUser getUserById(Long uid);

    /**
     * 注册
     *
     * @param tbUser
     * @return
     */
    String signIn(TbUser tbUser);
}
