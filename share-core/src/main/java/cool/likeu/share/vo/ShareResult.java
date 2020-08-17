package cool.likeu.share.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.function.Supplier;

@Data
public class ShareResult<T> implements Serializable {

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

    public static <T> ShareResult<T> success(Supplier<T> data) {
        return new ShareResult<>(200, data.get());
    }

    public static <T> ShareResult<T> failure(Integer status, String message) {
        return new ShareResult<>(status, message);
    }
}
