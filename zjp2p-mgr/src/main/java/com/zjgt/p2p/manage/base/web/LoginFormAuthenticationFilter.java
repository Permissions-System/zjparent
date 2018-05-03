/**
 * 软件著作权：百富金融技术部 项目名称互联网金融项目
 */
package com.zjgt.p2p.manage.base.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springfk.pancloud.utils.DateUtils;
//import org.springfk.pancloud.utils.UUIDUtils;
import com.zjgt.p2p.base.domain.LoginLog;
import com.zjgt.p2p.base.service.ILoginLogService;
import com.zjgt.util.UUIDUtils;

/**
 * 登录控制类
 * 
 * @author xrwang
 * 
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
    private static Logger logger = LoggerFactory.getLogger(LoginFormAuthenticationFilter.class);

    @Autowired
    private ILoginLogService loginLogService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        logger.debug("LoginFormAuthenticationFilter.isAccessAllowed");
        // 如果是登录请求，则拒绝进入以便转入重新登录处理
        if (super.isLoginRequest(request, response)) {
            logger.debug("Access not Allowed");
            return false;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     * 登录成功时执行
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        // ShiroStaff staff = (ShiroStaff)subject.getPrincipal();
        saveLoginLog((HttpServletRequest) request, "登录成功！");
        return super.onLoginSuccess(token, subject, request, response);
    }

    /**
     * 登录失败时执行
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        String loginDesc = null;
        if (e instanceof UnknownAccountException) {
            loginDesc = "账号不存在！";
        } else if (e instanceof IncorrectCredentialsException) {
            loginDesc = "输入密码错误!";
        } else {
            loginDesc = "验证失败";
        }
        saveLoginLog((HttpServletRequest) request, loginDesc);
        return super.onLoginFailure(token, e, request, response);
    }

    /**
     * 保存登录日志(同步记登录失败日志使用）
     * 
     * @param request
     * @param staffNo
     * @param loginName
     * @param result
     */
    private void saveLoginLog(HttpServletRequest request, String loginDesc) {
        String ip = request.getHeader("x-forwarded-for");
        String staffNo = null;
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        staffNo = (String) request.getAttribute("staffNo");
        if (staffNo == null) {
            staffNo = "NoAccount";
        }
        LoginLog loginLog = new LoginLog();
        loginLog.setRecNo(UUIDUtils.generate());
        loginLog.setIpAddress(ip);
        loginLog.setLoginDesc(loginDesc);
        loginLog.setSessionId(SecurityUtils.getSubject().getSession().getId().toString());
        loginLog.setStaffNo(staffNo);
        loginLog.setLoginTime(DateUtils.getCurrentFormatDate("yyyyMMdd HH:mm:ss"));
        try {
            loginLogService.addLoginLog(loginLog);
        } catch (Exception e) {
            logger.error("写入 oginLogService.addLoginLog 失败 ," + e);
        }

    }
}
