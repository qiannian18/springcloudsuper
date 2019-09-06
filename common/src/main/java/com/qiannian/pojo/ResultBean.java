package com.qiannian.pojo;

public class ResultBean<T> {
    private String  code;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
