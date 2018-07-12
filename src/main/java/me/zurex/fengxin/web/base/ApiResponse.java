package me.zurex.fengxin.web.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zurex
 * @date 2018/6/9
 * Make life more fun
 *
 * 所有对外暴露api统一使用该格式返回
 */
public class ApiResponse<T> {
    private int time;
    private int statusCode;
    private String statusMessage;
    private T result;


    public ApiResponse(ApiResponseStatus status, T result) {
        this.statusCode = status.getCode();
        this.statusMessage = status.getMessage();
        this.result = result;
    }

    public int getTime(){
        return time;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public String getStatusMessage(){
        return statusMessage;
    }

    public T getResult(){
        return result;
    }
}
