package com.september.web.sunrise.controller.demo;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.september.common.core.domain.AjaxResult;
import com.september.common.exception.base.JAssert;
import com.september.sunrise.entity.demo.request.SignContractRequest;
import com.september.sunrise.entity.demo.request.SignUploadRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RestController
@RequestMapping("/customer/contract")
public class SignContractController {


    @ApiOperation(value = "个人实名认证网页版")
    @PostMapping("/h5Sign")
    public AjaxResult h5Sign(@Validated @RequestBody SignContractRequest request) {

        String apiUrl = "https://prev.asign.cn/auth/person/identifyUrl";
        // 发送POST请求，并在body里直接写JSON字符串
        HttpResponse response = HttpRequest.post(apiUrl)
                .header("Content-Type", "application/json")  // 设置请求头为JSON类型
                .body("{\"realName\": \"" + request.getRealName() + "\", \"idcardno\": \"" + request.getIdCardNo() + "\"}")  // 直接在这里写入JSON字符串
                .execute();  // 执行请求

        // 输出结果
        System.out.println("POST Result: " + response.body());
        if(ObjectUtil.isEmpty(response.body())) {
            JAssert.failed("认证失败",500);
        }
        return AjaxResult.success("认证成功");
    }

    @ApiOperation(value = "文件上传方式")
    @PostMapping("/h5FileUpload")
    public AjaxResult h5(@Validated @RequestBody SignUploadRequest request) throws IOException, NoSuchAlgorithmException {

        String apiUrl = "https://prev.asign.cn/contract/get/upload/url";

        String contentMd5 = getContentMD5(request.getFilepath());

        // 发送POST请求，并在body里直接写JSON字符串
        HttpResponse response = HttpRequest.post(apiUrl)
                .header("Content-Type", "application/json")  // 设置请求头为JSON类型
                .body("{\"contentMd5\": \"" + contentMd5 + "\", \"filename\": \"" + request.getFilename()
                        + "\", \"extension\": \"" + request.getExtension() + "\", \"filesize\": \"" + request.getFilesize()
                        +"\"}")  // 直接在这里写入JSON字符串
                .execute();  // 执行请求

        // 输出结果
        System.out.println("POST Result: " + response.body());

        // 将返回的JSON字符串解析为JSONObject
        JSONObject jsonObject = JSONUtil.parseObj(response.body());
        if(!jsonObject.getInt("code").equals(10000)) {
            JAssert.failed("文件上传失败",500);
        }
        return AjaxResult.success("文件上传成功");
    }


    /**
     * 计算文件的ContentMD5
     * @param filepath 文件路径
     * @return String contentMd5
     */
    public static String getContentMD5(String filepath) throws IOException, NoSuchAlgorithmException {
        byte[] bytes = getMD5Bytes(filepath);
        return Base64.getEncoder().encodeToString(bytes);
    }
    /**
     * 获取文件MD5二进制数组
     * @param filepath 文件路径
     * @return byte[]
     */
    public static byte[]  getMD5Bytes(String filepath) throws IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(filepath);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[1024];
        int length;
        while((length = fis.read(buffer, 0, 1024)) != -1) {
            md5.update(buffer, 0, length);
        }
        fis.close();
        return md5.digest();
    }


}
