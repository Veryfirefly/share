package cool.likeu.share.vo;

import java.util.List;

@Deprecated
public class SharePage<T> {

    private Long current;

    private Long size;

    private Long total;

    private List<T> data;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SharePage{" +
                "current=" + current +
                ", total=" + total +
                ", size=" + size +
                ", data=" + data +
                '}';
    }
}
