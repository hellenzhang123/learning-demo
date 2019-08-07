package com.example.demo.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.SysPermission;
import com.example.demo.model.SysRole;
import com.example.demo.model.User;
import com.example.demo.sevice.UserService;

public class MyShiroRealm extends AuthorizingRealm {
  @Autowired
  private UserService userInfoService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    User userInfo = (User) principals.getPrimaryPrincipal();
    for (SysRole role : userInfo.getRoleList()) {
      authorizationInfo.addRole(role.getRole());
      for (SysPermission p : role.getPermissions()) {
        authorizationInfo.addStringPermission(p.getPermission());
      }
    }
    return authorizationInfo;
  }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
    String name = token.getUsername();
    String password = String.valueOf(token.getPassword());
    User user = new User();
    user.setName(name);
    user.setPassword(password);

    // 从数据库获取对应用户名密码的用户
    User userList = userInfoService.findByUsername(name);
    if (userList != null && userList.getPassword().equals(password)) {
      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userList, // 用户
          userList.getPassword(), // 密码
          getName() // realm name
      );
      return authenticationInfo;
        }
    throw new UnknownAccountException();
    }

}