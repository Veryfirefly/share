package cool.likeu.share.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date createTime;
    private Date modifyTime;

}
