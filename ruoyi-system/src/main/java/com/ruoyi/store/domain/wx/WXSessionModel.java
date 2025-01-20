package com.ruoyi.store.domain.wx;

import lombok.Data;

@Data
public class WXSessionModel {
    private String openid;
    private String session_key;
}
