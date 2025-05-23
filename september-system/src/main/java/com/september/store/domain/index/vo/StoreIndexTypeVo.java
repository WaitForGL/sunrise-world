package com.september.store.domain.index.vo;

import com.september.store.domain.index.StoreIndexType;
import lombok.Data;

import java.util.List;


/**
 * 首页返回一级二级层级集合 StoreIndexTypeVo
 *
 */
@Data
public class StoreIndexTypeVo{

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 标签名
     */
    private String typeName;

    /**
     * 标签级别(0:一级主分类)
     */
    private Integer typeLevel;

    /**
     * 上级id
     */
    private Integer belongId;

    /**
     * 标签颜色
     */
    private String color;

    /**
     * 标签状态（0:正常 1:删除）
     */
    private Integer status;

    /**
     * 返回给前端
     */
    private Boolean isExpand;

    /**
     * 返回给前端
     */
    private Boolean isAllChoosed;


    /**
     * 一级集合下的子集合
     */
    private List<StoreIndexType> list;
}
