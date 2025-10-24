package com.september.sunrise.kk.dto;

import lombok.Data;

/**
 * 陪玩入职申请 DTO
 */
@Data
public class PlaymateApplyDTO {
    private String nickname;     // 陪玩昵称
    private String phone;        // 联系手机
    private String wechat;       // 微信号
    private String gender;       // 性别（M/F）
    private String intro;        // 自我介绍
    private String avatar;       // 头像地址
}
