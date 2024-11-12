package com.september.web.sunrise.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.september.sunrise.entity.user.User;

public interface IUserService extends IService<User> {
    User isExistUser(String username, String password);

    void insertUser(String username, String password);
}
