package com.example.demo.controller;

import com.example.demo.domain.TbUser;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody TbUser tbUser){
        return loginService.login(tbUser);
    }
}
