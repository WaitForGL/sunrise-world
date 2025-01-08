package com.ruoyi.store.domain.index;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class StoreIndexType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 标签名
     */
    private String typeName;

    /**
     * 标签级别
     */
    private Integer typeLevel;

    /**
     * 标签级别
     */
    private Integer belongId;
}
