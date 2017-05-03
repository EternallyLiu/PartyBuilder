package com.github.rayboot.project.BuilderParty.service.response;

/**
 * Created by liupei on 2017/5/3.
 */

public class BaseResponse<T>{
    private T data;
    private int status_code;
    private String info;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
