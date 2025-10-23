package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface KkUserMapper {

    KkUser findByUsername(@Param("username") String username);

    List<KkUser> findAllAdminsWithDispatch();

    List<KkUser> findAllPlaymates();

    int insertAdmin(KkUser user);

    int updateAdmin(KkUser user);

    /**
     * 逻辑删除管理员（标记删除）
     */
    int removeManager(@Param("id") Long id);

    /**
     * 物理删除管理员（彻底删除）
     */
    int deleteManager(@Param("id") Long id);

    /**
     * 关键字查询管理员
     */
    List<KkUser> findAdminsByKeyword(@Param("keyword") String keyword);

    /**
     * 更新增加陪玩余额
     */
    int updatePlaymateIncome(@Param("playmateId") Long playmateId,
                             @Param("income") BigDecimal income);

}
