package com.ruoyi.store.domain.index;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.beans.Transient;
import java.util.List;

@Data
public class StoreIndexType{

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
    private Long belongId;

    /**
     * 标签状态（0:正常 1:删除）
     */
    private Integer status;

}
