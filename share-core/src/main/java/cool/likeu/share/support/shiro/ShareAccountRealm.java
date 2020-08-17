package cool.likeu.share.support.shiro;

import cool.likeu.share.dao.User;
import cool.likeu.share.service.ShareUserService;
import cool.likeu.share.util.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShareAccountRealm extends AuthorizingRealm {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ShareUserService shareUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return (token instanceof JwtToken);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        JwtToken token = (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimsByToken((String) token.getPrincipal()).getSubject();
        User user = shareUserService.getById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        ShiroUserBean shiroUserBean = new ShiroUserBean();
        BeanUtils.copyProperties(user, shiroUserBean);

        return new SimpleAuthenticationInfo(shiroUserBean, token.getCredentials(), getName());
    }
}
