package com.example.demo.controller;

import com.example.demo.domain.TbUser;
import com.example.demo.service.DemoService;
import com.example.demo.utils.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/selectAll")
    public List<TbUser> selectAll() {
        log.info("获取的登录对象:{}",LoginUtil.get());
        return demoService.selectAll();
    }
}
