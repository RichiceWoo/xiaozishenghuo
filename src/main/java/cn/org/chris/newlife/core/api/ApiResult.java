package cn.org.chris.newlife.core.api;

/**
 * @Description:返回结果解析
 * @Version:1.0
 * @Author:Richice
 * @Date:2019/1/25 17:30
 */
public class ApiResult {
    /**
     * 普通成功返回
     *
     * @return
     */
    public static ResponseObject success() {
        return build(MessageType.SUCCESS.getCode(), MessageType.SUCCESS.getMgs());
    }

    /**
     * 带数据成功返回
     *
     * @param object
     * @return
     */
    public static ResponseObject success(Object object) {
        return build(MessageType.SUCCESS.getCode(), MessageType.SUCCESS.getMgs(), object);
    }

    /**
     * 普通的服务器异常
     *
     * @return
     */
    public static ResponseObject error() {
        return build(MessageType.ERROR.getCode(), MessageType.ERROR.getMgs());
    }

    /**
     * 服务器异常并且返回结果 可能不会用到
     *
     * @param object
     * @return
     */
    public static ResponseObject error(Object object) {
        return build(MessageType.ERROR.getCode(), MessageType.ERROR.getMgs(), object);
    }

    /**
     * 参数错误返回
     *
     * @return
     */
    public static ResponseObject parameter_fail() {
        return build(MessageType.PARAMETER_FAIL.getCode(), MessageType.PARAMETER_FAIL.getMgs());
    }

    /**
     * 其他错误返回
     *
     * @param msg
     * @return
     */
    public static ResponseObject fail(String msg) {
        return build(MessageType.PARAMETER_FAIL.getCode(), msg);
    }

    public static ResponseObject build(int code, String msg) {
        return new ResponseObject(code, msg);
    }

    public static ResponseObject build(int code, String msg, Object object) {
        return new ResponseObject(code, msg, object);
    }
}
