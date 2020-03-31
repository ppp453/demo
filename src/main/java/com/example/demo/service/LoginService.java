package com.example.demo.service;

import com.example.demo.domain.TbUser;

public interface LoginService {

    String login(TbUser tbUser);

    TbUser queryByUserName(String userName);
}
