package com.example.demo.service.impl;

import com.example.demo.dao.TbUserMapper;
import com.example.demo.domain.TbUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserById(Long uid) {

        return tbUserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public String signIn(TbUser tbUser) {
        //加密操作(略
        tbUser.setCreateDate(new Date());
        tbUser.setModifyDate(new Date());
        tbUserMapper.insertSelective(tbUser);
        return "ok";
    }
}
