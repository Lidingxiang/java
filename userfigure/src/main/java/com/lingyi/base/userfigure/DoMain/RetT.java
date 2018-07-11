package com.lingyi.base.userfigure.DoMain;

public class RetT<T> extends Ret {

    private T data;

    public RetT(T data) {
        this.data = data;
    }

    public RetT(int status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}