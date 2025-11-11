package com.september.sunrise.kk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.september.sunrise.kk.domain.KkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface KkUserMapper extends BaseMapper<KkUser> {
    //获取用户详情
    KkUser selectByUsername(@Param("username") String username);

    // 查询客服列表
    List<KkUser> selectManagerList(@Param("status") Integer status);

    // 新增客服
    int insertManager(KkUser user);

    // 删除客服
    int deleteManager(@Param("id") Long id);

    // 离职：状态改为2，同时角色改为顾客
    int updateManagerStatus(@Param("id") Long id);

    int updateUserVip(KkUser user);

}
