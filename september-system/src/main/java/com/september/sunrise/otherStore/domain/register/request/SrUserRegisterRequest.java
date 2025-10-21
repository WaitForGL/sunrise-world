package com.september.sunrise.otherStore.domain.register.request;

import com.september.common.annotation.Excel;
import lombok.Data;

@Data
public class SrUserRegisterRequest {

    @Excel(name = "用户名")
    private String username;

    @Excel(name = "密码")
    private String password;
}
