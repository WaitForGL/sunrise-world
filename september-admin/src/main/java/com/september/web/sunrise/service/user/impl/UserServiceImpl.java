package com.september.web.sunrise.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.sunrise.until.StringUtils;
import com.september.sunrise.entity.user.User;
import com.september.sunrise.mapper.user.UserMapper;
import com.september.web.sunrise.service.user.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User isExistUser(String username, String password) {
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUsername,username);
        userQueryWrapper.eq(User::getPassword,password);
        User user = baseMapper.selectOne(userQueryWrapper);
        if(StringUtils.isNull(user)){
            return null;
        }else {
            return user;
        }

    }

    @Override
    public void insertUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        baseMapper.insert(user);
    }
}
