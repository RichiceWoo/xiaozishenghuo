package cn.org.chris.newlife.core.api;

/**
 * 使用枚举记录消息类型
 */
public enum MessageType {
    /**
     * 有无数据都可返回，表示请求成功
     */
    SUCCESS(200, "请求成功"),

    PARAMETER_FAIL(201, "参数错误"),

    /**
     * 根据实际的业务返回
     */
    FAIL(202, "自定义错误"),

    /**
     * 系统异常，一般指500错误
     */
    ERROR(-1, "系统异常"),

    /**
     * 需要身份验证时候用到
     */
    LOGINERROR(-2, "未登陆或SESSION超时");


    private int code;
    private String mgs;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }

    MessageType(int code, String mgs) {
        this.code = code;
        this.mgs = mgs;
    }

    public static String getMsg(int code) {
        for (MessageType mt : values()
                ) {
            if (mt.getCode() == code) {
                return mt.getMgs();
            }
        }
        return null;
    }
}
