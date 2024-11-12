package com.september.sunrise.entity.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SignContractRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户姓名")
    private String realName;

    @ApiModelProperty(value = "身份证号")
    private String idCardNo;
}
