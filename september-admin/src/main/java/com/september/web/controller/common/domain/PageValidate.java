package com.september.web.controller.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel("分页参数")
public class PageValidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小为 1")
    @ApiModelProperty(value = "页码", example = "1", required = true)
    private Integer pageNo;

    @NotNull(message = "每页数量不能为空")
    @Min(value = 10, message = "每页最少 1 条")
    @ApiModelProperty(value = "每页数量", example = "10", required = true)
    private Integer pageSize;

}
