package com.september.sunrise.kk.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.september.sunrise.kk.domain.KkUser;
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


}
