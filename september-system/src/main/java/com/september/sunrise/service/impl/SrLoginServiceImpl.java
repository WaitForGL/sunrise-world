package com.september.sunrise.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.common.constant.Constants;
import com.september.common.utils.JAssert;
import com.september.common.utils.StringUtils;
import com.september.common.utils.uuid.IdUtils;
import com.september.sunrise.domain.login.request.SrUserLoginRequest;
import com.september.sunrise.domain.user.SrUser;
import com.september.sunrise.mapper.SrLoginMapper;
import com.september.sunrise.service.SrLoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class SrLoginServiceImpl extends ServiceImpl<SrLoginMapper, SrUser> implements SrLoginService {

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    @Override
    public String login(SrUserLoginRequest request) {
        if(StringUtils.isNull(request.getUsername())){
            JAssert.justFailed("请输入用户名");
        }
        LambdaQueryWrapper<SrUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SrUser::getUsername,request.getUsername());
        SrUser srUser = baseMapper.selectOne(queryWrapper);
        if(ObjectUtil.isNull(srUser)){
            JAssert.justFailed("用户不存在");
        }
        if(StringUtils.isNull(request.getPassword())){
            JAssert.justFailed("未输入密码");
        }
        if(!request.getPassword().equals(srUser.getPassword())){
            JAssert.justFailed("密码错误");
        }
        // 生成token
        return this.createToken(request);
    }

    /**
     * 创建令牌
     *
     * @param request 用户信息
     * @return 令牌
     */
    public String createToken(SrUserLoginRequest request)
    {
        String token = IdUtils.fastUUID();

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }
}
