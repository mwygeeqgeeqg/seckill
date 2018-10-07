package org.seckill.dto;

/**
 * Created by liguotao on 17/12/24.
 */
public class SeckillResult<T> {
    private boolean success;
    private T data;
    private String errorMesg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMesg() {
        return errorMesg;
    }

    public void setErrorMesg(String errorMesg) {
        this.errorMesg = errorMesg;
    }

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(boolean success, String errorMesg) {
        this.success = success;
        this.errorMesg = errorMesg;
    }
}
