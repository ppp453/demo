package com.example.demo.service.impl;

import com.example.demo.dao.TbUserMapper;
import com.example.demo.domain.TbUser;
import com.example.demo.domain.TbUserExample;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectByExample(new TbUserExample());
    }
}
