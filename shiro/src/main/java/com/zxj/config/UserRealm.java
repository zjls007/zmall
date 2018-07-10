package com.zxj.config;

import com.zxj.dao.UserInfoDAO;
import com.zxj.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zxj on 2017/2/17.
 * AuthorizingRealm授权类继承了AuthenticatingRealm认证类
 * 所以这里实行AuthorizingRealm授权类本身的授权方法doGetAuthorizationInfo
 * 和继承自AuthenticatingRealm认证类的认证方法doGetAuthenticationInfo
 */
public class UserRealm extends AuthorizingRealm {

    public static final String CURRENT_USER_ID = "currentUserId";

    @Autowired
    private UserInfoDAO userInfoDAO;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Long currentUserId = (Long) SecurityUtils.getSubject().getSession().getAttribute(CURRENT_USER_ID);
        if (currentUserId != null) {
            UserInfo userInfo = userInfoDAO.findOne(currentUserId);

            Set<String> roles = new HashSet<>(Arrays.asList(new String[] {"admin"}));
            authorizationInfo.setRoles(roles);

            Set<String> perms = new HashSet<>(Arrays.asList(new String[] {}));
            authorizationInfo.setStringPermissions(perms);
        }
        return authorizationInfo;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // principal 身份, credentials 凭证
        String principal = (String) authenticationToken.getPrincipal();

        UserInfo query = new UserInfo();
        query.setUsername(principal);
        UserInfo userInfo = userInfoDAO.findOne(Example.of(query));

        if (userInfo == null) {
            // 账户不存在
            throw new UnknownAccountException();
        } else if (userInfo.getLocked()) {
            // 账户被锁定
            throw new LockedAccountException();
        }

        // 密码不正确会在 SimpleAuthenticationInfo验证
        // 下面为比较明文密码
        // return new SimpleAuthenticationInfo(principal, userInfo.getPassword(), getName());
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getUsername() + userInfo.getSalt()),
                getName());
        SecurityUtils.getSubject().getSession().setAttribute(CURRENT_USER_ID, userInfo.getId());
        return authenticationInfo;
    }

    private String getPassword(String username, String password, String salt) {
        if (salt == null) {
            salt = getSalt();
        }
        SimpleHash hash = new SimpleHash("md5", password, username + salt, 2);
        return hash.toHex();
    }

    private String getSalt() {
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }

}
