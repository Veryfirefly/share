package cool.likeu.share.controller;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cool.likeu.share.dao.User;
import cool.likeu.share.service.ShareUserService;
import cool.likeu.share.util.JwtUtils;
import cool.likeu.share.vo.LoginDTO;
import cool.likeu.share.vo.ShareResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class ShareUserController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ShareUserService shareUserService;

    @PostMapping("/login")
    public ShareResult<LoginDTO> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        User user = shareUserService.getOne(
                Wrappers.<User>lambdaQuery()
                        .eq(User::getUsername, loginDTO.getUsername()));
        String reqPassword = SecureUtil.md5(loginDTO.getPassword());

        if (!user.getPassword().equals(reqPassword)) {
            return ShareResult.failure(500, "用户名或密码不正确.");
        } else {
            String token = jwtUtils.generateToken(user.getId());

            response.setHeader("Authorization", token);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");

            LoginDTO respUserDTO = new LoginDTO();
            BeanUtils.copyProperties(user, respUserDTO);
            return ShareResult.success(200, respUserDTO);
        }
    }

    @RequiresAuthentication
    @DeleteMapping("/logout")
    public ShareResult<Boolean> logout() {
        SecurityUtils.getSubject().logout();;
        return ShareResult.success(200, true);
    }
}
