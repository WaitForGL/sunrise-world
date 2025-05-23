package com.september.sunrise.domain.user;

import com.september.common.annotation.Excel;
import com.september.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class SrUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "id")
    private Long id;

    @Excel(name = "用户名")
    private String username;

    @Excel(name = "密码")
    private String password;
}
