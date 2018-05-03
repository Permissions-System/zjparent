/**
 * 软件著作权：百富金融技术部 项目名称：互联网金融样例项目
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springfk.pancloud.utils.EncodesUtils;

import com.zjgt.p2p.manage.base.shiro.SimplePermission;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * shiro权限控制
 * 
 * @author Administrator
 * 
 */
public class ShiroDbRealm extends AuthorizingRealm {
    
    Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private IStaffAccountService staffAccountService;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Staff staff = null;
        try {
            staff = staffAccountService.findStaffByIdentNo(token.getUsername());
        } catch (Exception e) {
            logger.error("staffAccountService.findStaffByIdentNo error ", e);
            return null;
        }
        if (staff != null) {
            final HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils.getSubject()).getServletRequest();
            request.setAttribute("staffNo", staff.getStaffNo());//员工编码
            request.setAttribute("staffType", staff.getStaffType());//员工类型
            request.setAttribute("channelCode", staff.getChannelCode());//渠道商编号
            request.getSession().setAttribute("staffNo", staff.getStaffNo());
            request.getSession().setAttribute("staffType", staff.getStaffType());
            request.getSession().setAttribute("channelCode", staff.getChannelCode());
            byte[] salt = EncodesUtils.decodeHex(staff.getSalt());//SALT值(解码)
            return new SimpleAuthenticationInfo(new ShiroStaff(staff.getIdentNo(), staff.getName(), staff.getStaffNo()), staff.getPwd(), ByteSource.Util.bytes(salt), getName());
        } else {
            return null;
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroStaff shiroStaff = (ShiroStaff) principals.getPrimaryPrincipal();
        String staffNo = shiroStaff.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(staffAccountService.getRoles(staffNo));
        List<Transaction> transList = null;
        if (shiroStaff.isSupervisor()) {//管理员
            transList = staffAccountService.getTransPermissionsForAdmin();
        } else {//非管理员
            transList = staffAccountService.getTransPermissions(staffNo);
        }
        if (transList != null && transList.size() > 0) {
            List<Permission> spList = new ArrayList<Permission>();// 自定义权限验证列表
            List<String> codeList = new ArrayList<String>();// 默认权限验证列表，使用交易码,兼容使用注解标签等
            for (Transaction trans : transList) {
                spList.add(new SimplePermission(trans.getUrl(), trans.getTransCode()));
                codeList.add(trans.getTransCode());
            }
            info.addObjectPermissions(spList);
            info.addStringPermissions(codeList);
        }
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        matcher.setHashIterations(1024);

        setCredentialsMatcher(matcher);
    }

    public void setStaffAccountService(IStaffAccountService staffAccountService) {
        this.staffAccountService = staffAccountService;
    }
}