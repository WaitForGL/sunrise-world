package com.september.store.domain.focus;

import lombok.Data;


@Data
public class StoreFocus {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 店铺id
     */
    private Long shopId;
}
