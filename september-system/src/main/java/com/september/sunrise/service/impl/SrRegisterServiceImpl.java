package com.september.sunrise.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.common.utils.JAssert;
import com.september.sunrise.domain.register.request.SrUserRegisterRequest;
import com.september.sunrise.domain.user.SrUser;
import com.september.sunrise.mapper.RegisterMapper;
import com.september.sunrise.service.SrRegisterService;
import org.springframework.stereotype.Service;

@Service
public class SrRegisterServiceImpl extends ServiceImpl<RegisterMapper, SrUser> implements SrRegisterService {

    @Override
    public void register(SrUserRegisterRequest request) {

        LambdaQueryWrapper<SrUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SrUser::getUsername,request.getUsername());
        SrUser srUser = baseMapper.selectOne(queryWrapper);
        if(ObjectUtil.isNotNull(srUser)){
            JAssert.justFailed("用户已存在，请登录");
        }
        //用户不存在 创建用户
        SrUser newUser = new SrUser();
        newUser.setUsername(request.getUsername());
        baseMapper.insert(newUser);
    }
}
