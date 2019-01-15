package com.demo.form;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResponseVo<V> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode = "0";

    private boolean success;
    private String msg;
    private V data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 无参构造
     */
    public ResponseVo() {
        super();
    }
}
