package com.september.sunrise.kk.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.PlaymateApplyDTO;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private KkUserMapper userMapper;

    @Override
    public List<KkUser> adminList() {
        return userMapper.findAllAdminsWithDispatch();
    }

    @Override
    public List<KkUser> findAdminsByKeyword(String keyword) {
        return userMapper.findAdminsByKeyword(keyword);
    }

    @Override
    public List<KkUser> playmateList() {
        return userMapper.findAllPlaymates();
    }

    @Override
    public KkUser findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAdmin(KkUser user) {
        // MD5 加密密码
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        int result = userMapper.insertAdmin(user);
        if (result == 0) {
            throw new RuntimeException("新增管理员失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdmin(KkUser user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        }
        int result = userMapper.updateAdmin(user);
        if (result == 0) {
            throw new RuntimeException("更新管理员失败，ID不存在或已删除");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeManager(Long id) {
        int result = userMapper.removeManager(id);
        if (result == 0) {
            throw new RuntimeException("逻辑删除管理员失败，ID不存在或已删除: " + id);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteManager(Long id) {
        int result = userMapper.deleteManager(id);
        if (result == 0) {
            throw new RuntimeException("物理删除管理员失败，ID不存在: " + id);
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void applyPlaymate(PlaymateApplyDTO dto) {
        // 1. 检查重复手机号或微信
        if (userMapper.existsByPhoneOrWechat(dto.getPhone(), dto.getWechat()) > 0) {
            throw new RuntimeException("该手机号或微信已注册，请勿重复申请");
        }

        // 2. 生成用户对象
        KkUser user = new KkUser();
        user.setUsername(dto.getPhone());
        user.setNickname(dto.getNickname());
        user.setPhone(dto.getPhone());
        user.setWechat(dto.getWechat());
        user.setGender("M".equalsIgnoreCase(dto.getGender()) ? 1 : 2);
        user.setIntro(dto.getIntro());
        user.setAvatar(dto.getAvatar());
        user.setRoleCode("PLAYMATE");
        user.setPassword(DigestUtil.md5Hex("123456")); // 默认初始密码
        user.setStatus(0); // 0=待审核

        // 3. 插入数据库
        int result = userMapper.insertPlaymate(user);
        if (result == 0) {
            throw new RuntimeException("陪玩申请提交失败，请稍后再试");
        }
    }



}
