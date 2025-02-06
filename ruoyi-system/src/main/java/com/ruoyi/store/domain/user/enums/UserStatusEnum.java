package com.ruoyi.store.domain.user.enums;

public enum UserStatusEnum {

    START(0, "正常"),
    STOP(1, "停用");

    /**
     * 构造方法
     */
    private final int code;
    private final String msg;
    UserStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取状态码
     *
     * @author fzr
     * @return Long
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 获取提示
     *
     * @author fzr
     * @return String
     */
    public String getMsg() {
        return this.msg;
    }
}
