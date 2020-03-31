package com.example.demo.controller;

import com.example.demo.domain.TbUser;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.BizErrorCodeEnum;
import com.example.demo.service.UserService;
import com.example.demo.utils.LoginUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "用户操作接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public TbUser getUser(){
        return LoginUtil.get();
    }


    @GetMapping("/getUserById")
    @ApiOperation("通过用户id获取用户信息")
    public TbUser getUserById(@RequestParam("id") Long uid) {
        if (uid == null) {
            throw new BaseException(BizErrorCodeEnum.ID_IS_NULL);
        }
        return userService.getUserById(uid);
    }


    @PostMapping("/signIn")
    public String signIn(@RequestBody TbUser tbUser) {
        if (tbUser == null) {
            throw new BaseException(BizErrorCodeEnum.REQUEST_ERROR);
        }
        if (StringUtils.isBlank(tbUser.getUsername())) {
            throw new BaseException(BizErrorCodeEnum.USERNAME_IS_NULL);
        }
        if (StringUtils.isBlank(tbUser.getPassword())) {
            throw new BaseException(BizErrorCodeEnum.PASSWORD_IS_NULL);
        }

        return userService.signIn(tbUser);
    }
}
