package com.september.sunrise.entity.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SignUploadRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "文件路径")
    private String filepath;

    @ApiModelProperty(value = "文件名称，请勿携带扩展名称")
    private String filename;

    @ApiModelProperty(value = "extension")
    private String extension;

    @ApiModelProperty(value = "文件大小，单位byte，单个文件大小不能超过100M")
    private Long filesize;
}
