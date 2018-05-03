/**
 * 软件著作权：百富金融技术部 项目名称互联网金融项目
 */
package com.zjgt.p2p.manage.base.shiro;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import com.zjgt.p2p.base.domain.ShiroStaff;

/**
 * user权限控制类
 * 
 * @author xrwang
 * 
 */
public class SimpleUserFilter extends UserFilter {
    private static Logger logger = LoggerFactory.getLogger(SimpleUserFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        long startTime = new Date().getTime();
        logger.debug("SimpleUserFilter.isAccessAllowed?");
        // 登录请求，通过
        if (isLoginRequest(request, response)) {
            logger.debug("isLoginRequest");
        } else {
            Subject subject = getSubject(request, response);
            ShiroStaff staff = (ShiroStaff) subject.getPrincipal();
            if (subject == null || !subject.isAuthenticated()) {
                logger.debug("登录超时，请您退出系统，重新登录！subject == null || !subject.isAuthenticated");
                long endTime = new Date().getTime();
                logger.debug("------\t total deal time: " + (endTime - startTime) + "\t--------");
               
                // update by liulei 2015年1月8日 17:15:10
                throw new BusinessException("登录超时，请您退出系统，重新登录！");
                /*try {
                	redirectToLogin(request, response);
                    //saveRequestAndRedirectToLogin(request, response);
                } catch (IOException e) {
                	logger.error(this.getClass().getName(),e);
                	//e.printStackTrace();
                	
                    try {
                        redirectToLogin(request, response);
                    } catch (IOException e1) {
                        return false;
                    }
                }
                return false;*/
            } else {
                // 超级管理员超级权限
                if (staff != null && staff.isSupervisor()) {
                    return true;
                }
                if (!"XMLHttpRequest".equals(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
                    if (!subject.isPermitted(new SimplePermission(getPathWithinApplication(request), null))) {
                        throw new BusinessException("您未被授权查看该页面！");
                    }
                } else {
                    // TODO ajax请求也应该进行资源权限判断 , 因为原系统中未做ajax拦截,也没有统计ajax资源
                    // 1.业务系统ajax请求都必须.do,用以区分基础模块中未统计的ajax权限,这里只拦截.do的ajax请求
                    // 2.权限判断中不区分后缀
                    if (getPathWithinApplication(request).lastIndexOf(".do")!=-1 && !subject.isPermitted(new SimplePermission(getPathWithinApplication(request), null))) {
                        throw new BusinessException("您未被授权！");
                    } 
                }
            }
        }
        long endTime = new Date().getTime();
        logger.debug("------\t total deal time: " + (endTime - startTime) + "\t--------");
        return true;
    }
}
