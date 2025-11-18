package com.september.sunrise.kk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.september.sunrise.kk.domain.KkPlaymateGame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkPlaymateGameMapper extends BaseMapper<KkPlaymateGame> {


    /**
     * 自动派单：根据游戏ID和陪玩等级ID获取可用陪玩列表
     */
    List<KkPlaymateGame> listByGameAndLevel(@Param("gameId") Long gameId,
                                            @Param("levelId") Long levelId);

    /**
     * 查询陪玩支持的游戏及价格列表
     */
    List<KkPlaymateGame> listByPlaymate(@Param("playmateId") Long playmateId);

    /**
     * 根据陪玩ID和游戏ID查询指定陪玩可接的游戏单
     */
    KkPlaymateGame getByPlaymateAndGame(@Param("playmateId") Long playmateId,
                                        @Param("gameId") Long gameId);

    /**
     * 自动派单查询可用陪玩
     */
    KkPlaymateGame getAvailablePlaymate(@Param("gameId") Long gameId,
                                        @Param("levelId") Long levelId);
}
