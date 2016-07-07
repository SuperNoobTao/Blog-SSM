package cn.edu.zucc.service;

import cn.edu.zucc.mapper.RoleMapper;
import cn.edu.zucc.mapper.UserMapper;
import cn.edu.zucc.pojo.TbRoleEntity;
import cn.edu.zucc.pojo.TbUserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;


    /**
     * 权限认证方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        TbUserEntity shiroUser = (TbUserEntity) principalCollection.getPrimaryPrincipal();

        TbUserEntity user = userMapper.queryByAcount(shiroUser.getUserAcount());
        if(user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //获取用户对应的角色
            TbRoleEntity roleList = roleMapper.QueryByUserId(user.getUserId());

                info.addRole(roleList.getRoleName());

            return info;
        }

        return null;
    }

    /**
     * 登录方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String acount = token.getUsername();
        TbUserEntity user = userMapper.queryByAcount(acount);
        if(user != null) {
            if(user.USER_STATE_DISABLE.equals(user.getUserState())) {
                throw new LockedAccountException("该账号已被禁用");
            }
            return new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
        }
        throw new UnknownAccountException("账号或密码错误");
    }



}
