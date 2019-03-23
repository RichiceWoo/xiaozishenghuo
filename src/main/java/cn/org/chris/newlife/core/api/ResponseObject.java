package cn.org.chris.newlife.core.api;

import lombok.Data;

/**
 * @Description:数据请求返回对象
 * @Version:1.0
 * @Author:Richice
 * @Date:2019/1/25 17:22
 */
@Data
public class ResponseObject {
    private int code;//状态码
    private String msg;//消息
    private Object object;//返回数据


    public ResponseObject(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public ResponseObject(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
