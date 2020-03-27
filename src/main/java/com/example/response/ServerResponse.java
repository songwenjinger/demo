package com.example.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * JsonSerialize.Inclusion.NON_NULL保证序列化json的时候,如果是null的对象,key也会消失
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int code;
    private String message;
    private T result;

    private ServerResponse(int code) {
        this.code = code;
    }

    private ServerResponse(int code, T result) {
        this.code = code;
        this.result = result;
    }

    private ServerResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    private ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getresult() {
        return result;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createBySuccess(T result) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), result);
    }

    public static <T> ServerResponse<T> createBySuccess(String message, T result) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), message, result);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int code, String errorMessage) {
        return new ServerResponse<T>(code, errorMessage);
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

}
