package com.simpletour.tzq.model;

/**
 * Created by zhiqiang on 2017/3/17.
 *
 * @param <T> 返回实体类型
 */
public class BaseRespones<T> {

    /**
     * @param data
     */
    public BaseRespones(T data) {
        this.data = data;
    }

    /**
     * 状态码
     */
    Integer statusCode = 200;


    /**
     * 返回实体类型
     */
    T data;

    /**
     * 错误信息
     */
    String errorMessage;

    /**
     * @return
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
