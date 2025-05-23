package com.september.store.domain.user.enums;

public enum UserTypeEnum {

    JOIN_MEMBER(0, "合伙人"),
    VIP(1, "VIP"),
    MEMBER(2,"普通用户");

    /**
     * 构造方法
     */
    private final int code;
    private final String msg;
    UserTypeEnum(int code, String msg) {
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
