package com.example.demo.service.impl;

import com.example.demo.dao.TbUserMapper;
import com.example.demo.domain.TbUser;
import com.example.demo.domain.TbUserExample;
import com.example.demo.exception.BaseException;
import com.example.demo.service.LoginService;
import com.example.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public String login(TbUser tbUser) {
        String username = tbUser.getUsername();
        TbUser user = queryByUserName(username);
        if (user == null) {
            throw new BaseException("用户名不正确");
        }
        if (!user.getPassword().equals(tbUser.getPassword())) {
            throw new BaseException("密码不正确");
        }
        return JwtUtil.createJWT(1000*60*60, user);
    }

    @Override
    public TbUser queryByUserName(String userName){
        TbUserExample tbUserExample = new TbUserExample();
        tbUserExample.createCriteria().andUsernameEqualTo(userName);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        return tbUsers.size() > 0 ? tbUsers.get(0) : null;
    }
}
