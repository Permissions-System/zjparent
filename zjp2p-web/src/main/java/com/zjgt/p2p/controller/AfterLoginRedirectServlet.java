package com.zjgt.p2p.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;

@SuppressWarnings("serial")
public class AfterLoginRedirectServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html; charset=utf-8");

    PrintWriter out = response.getWriter();
    try
    {
      AccessToken accessTokenObj = new Oauth().getAccessTokenByRequest(request);

      String accessToken = null;
      String openID = null;
      long tokenExpireIn = 0L;

      if (accessTokenObj.getAccessToken().equals(""))
      {
        System.out.println("QQ Login Token is null---");
        System.out.print("没有获取到响应参数");
      } else {
        accessToken = accessTokenObj.getAccessToken();
        tokenExpireIn = accessTokenObj.getExpireIn();

        request.getSession().setAttribute("demo_access_token", accessToken);
        request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

        OpenID openIDObj = new OpenID(accessToken);
        openID = openIDObj.getUserOpenID();

        System.out.println(new StringBuilder().append("欢迎你，代号为 ").append(openID).append(" 的用户!").toString());
        request.getSession().setAttribute("demo_openid", openID);
        out.println("<a href=/shuoshuoDemo.html target=\"_blank\">去看看发表说说的demo吧</a>");

        System.out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
        com.qq.connect.api.qzone.UserInfo qzoneUserInfo = new com.qq.connect.api.qzone.UserInfo(accessToken, openID);
        com.qq.connect.javabeans.qzone.UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
        out.println("<br/>");
        if (userInfoBean.getRet() == 0) {
          System.out.println(new StringBuilder().append(userInfoBean.getNickname()).append("<br/>").toString());
          System.out.println(new StringBuilder().append(userInfoBean.getGender()).append("<br/>").toString());
          out.println(new StringBuilder().append("黄钻等级： ").append(userInfoBean.getLevel()).append("<br/>").toString());
          out.println(new StringBuilder().append("会员 : ").append(userInfoBean.isVip()).append("<br/>").toString());
          out.println(new StringBuilder().append("黄钻会员： ").append(userInfoBean.isYellowYearVip()).append("<br/>").toString());
          out.println(new StringBuilder().append("<image src=").append(userInfoBean.getAvatar().getAvatarURL30()).append("/><br/>").toString());
          out.println(new StringBuilder().append("<image src=").append(userInfoBean.getAvatar().getAvatarURL50()).append("/><br/>").toString());
          out.println(new StringBuilder().append("<image src=").append(userInfoBean.getAvatar().getAvatarURL100()).append("/><br/>").toString());
        } else {
          System.out.println(new StringBuilder().append("很抱歉，我们没能正确获取到您的信息，原因是： ").append(userInfoBean.getMsg()).toString());
        }
        System.out.println("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- end </p>");
        System.out.println("<p> start ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ start <p>");
        PageFans pageFansObj = new PageFans(accessToken, openID);
        PageFansBean pageFansBean = pageFansObj.checkPageFans("97700000");
        if (pageFansBean.getRet() == 0)
          System.out.println(new StringBuilder().append("<p>验证您").append((pageFansBean.isFans()) ? "是" : "不是").append("QQ空间97700000官方认证空间的粉丝</p>").toString());
        else {
          System.out.println(new StringBuilder().append("很抱歉，我们没能正确获取到您的信息，原因是： ").append(pageFansBean.getMsg()).toString());
        }
        System.out.println("<p> end ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ end <p>");
        System.out.println("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- start </p>");
        com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(accessToken, openID);
        com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo.getUserInfo();
        if (weiboUserInfoBean.getRet() == 0)
        {
          out.println(new StringBuilder().append("<image src=").append(weiboUserInfoBean.getAvatar().getAvatarURL30()).append("/><br/>").toString());
          out.println(new StringBuilder().append("<image src=").append(weiboUserInfoBean.getAvatar().getAvatarURL50()).append("/><br/>").toString());
          out.println(new StringBuilder().append("<image src=").append(weiboUserInfoBean.getAvatar().getAvatarURL100()).append("/><br/>").toString());

          System.out.println(new StringBuilder().append("<p>尊敬的用户，你的生日是： ").append(weiboUserInfoBean.getBirthday().getYear()).append("年").append(weiboUserInfoBean.getBirthday().getMonth()).append("月").append(weiboUserInfoBean.getBirthday().getDay()).append("日").toString());

          StringBuffer sb = new StringBuffer();
          sb.append(new StringBuilder().append("<p>所在地:").append(weiboUserInfoBean.getCountryCode()).append("-").append(weiboUserInfoBean.getProvinceCode()).append("-").append(weiboUserInfoBean.getCityCode()).append(weiboUserInfoBean.getLocation()).toString());

          ArrayList<?> companies = weiboUserInfoBean.getCompanies();
          if (companies.size() > 0)
          {
            int i = 0; for (int j = companies.size(); i < j; ++i) {
              sb.append(new StringBuilder().append("<p>曾服役过的公司：公司ID-").append(((Company)companies.get(i)).getID()).append(" 名称-").append(((Company)companies.get(i)).getCompanyName()).append(" 部门名称-").append(((Company)companies.get(i)).getDepartmentName()).append(" 开始工作年-").append(((Company)companies.get(i)).getBeginYear()).append(" 结束工作年-").append(((Company)companies.get(i)).getEndYear()).toString());
            }

          }

          System.out.println(sb.toString());
        } else {
          System.out.println(new StringBuilder().append("很抱歉，我们没能正确获取到您的信息，原因是： ").append(weiboUserInfoBean.getMsg()).toString());
        }
        System.out.println("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>");
      }
    } catch (QQConnectException e) {
      e.printStackTrace();
    }
  }
}