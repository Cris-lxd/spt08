package top.cris15.utils;

import lombok.Data;

/**
 * date： 2023/8/22
 * time： 21:22
 * author： cris
 * description：
 **/

@Data
public class R {

    /**
     * 是否成功
     **/
    private Boolean isSuccess;
    /**
     * 错误信息
     **/
    private String message;
    /**
     * 请求状态 200-成功 400-失败
     **/
    private Integer status;
    /**
     * 返回结果
     **/
    private Object data;

    public R(){};

    public R(boolean b, String message, int status, Object data) {
        this.isSuccess = b;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static R ok() {
        return new R(true, "success", 200 ,null);
    }

    public static R ok(String message) {
        return new R(true, message, 200,null);
    }

    public static R ok(String message,Object data) {
        return new R(true, message, 200,data);
    }

    public static R ok(Object data) {
        return new R(true, "success", 200,data);
    }

    public static R fail() {
        return new R(false, "error", 400 ,null);
    }
    public static R fail(String errorMsg) {
        return new R(false, errorMsg, 400 ,null);
    }

}
