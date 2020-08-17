package cool.likeu.share.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class MovieDTO {

    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @NotEmpty
    private String url;

    @JsonProperty("cover_image_url")
    private String coverImageUrl;

    private Float score;

    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    private Date modifyTime;

}
