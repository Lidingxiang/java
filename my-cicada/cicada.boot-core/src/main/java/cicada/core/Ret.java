package cicada.core;

public class Ret<T> {
    private int status = 0;
    private String message;
    private T Data;

    public Ret() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.Data;
    }

    public void setData(T data) {
        this.Data = data;
    }
}