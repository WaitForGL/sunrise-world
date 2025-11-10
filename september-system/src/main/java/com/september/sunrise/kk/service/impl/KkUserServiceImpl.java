package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.KkUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KkUserServiceImpl implements KkUserService {

    @Resource
    private KkUserMapper kkUserMapper;

    @Override
    public KkUser getByUsername(String username) {
        return kkUserMapper.selectByUsername(username);
    }
}
