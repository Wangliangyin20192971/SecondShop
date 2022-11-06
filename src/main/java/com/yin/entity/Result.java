package com.yin.entity;

import java.io.Serializable;

/**
 * @Classname Result
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/22 10:10
 * @Version 1.0
 **/
public class Result<T> implements Serializable {
    private boolean success;
    private String message;
    private T data;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
