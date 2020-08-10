package cool.likeu.share.vo;

public class ShareResult<T> {

    private Integer status;

    private T data;

    private String message;

    public ShareResult(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public ShareResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> ShareResult<T> success(Integer status, T data) {
        return new ShareResult<>(status, data);
    }

    public static <T> ShareResult<T> failure(Integer status, String message) {
        return new ShareResult<>(status, message);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ShareResult{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
