package com.september.sunrise.domain.register.request;

import com.september.common.annotation.Excel;
import lombok.Data;

@Data
public class SrUserRegisterRequest {

    @Excel(name = "用户名")
    private String username;
}
