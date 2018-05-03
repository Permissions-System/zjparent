package com.zjgt.p2p.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/login"})
public class LoginController
{
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView login(HttpServletRequest request, String errormsg, String username)
    throws Exception
  {
    Subject subject = SecurityUtils.getSubject();

    String preurl = request.getParameter("preurl");
    request.getSession().setAttribute("preurl", preurl);
    if (subject.isAuthenticated())
    {
      return new ModelAndView("redirect:/index.do");
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    modelAndView.addObject("errormsg", errormsg);
    modelAndView.addObject("username", username);

    if (request.getParameter("hideCheckbox") != null) {
      modelAndView.addObject("hideCheckbox", request.getParameter("hideCheckbox"));
    }
    if (request.getParameter("password") != null) {
      modelAndView.addObject("password", request.getParameter("password"));
    }
    if (request.getParameter("email") != null) {
      modelAndView.addObject("email", request.getParameter("email"));
    }
    if (request.getParameter("login") != null) {
      modelAndView.addObject("login", request.getParameter("login"));
    }
    return modelAndView;
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView fail(@RequestParam("username") String username, String password, String checkbox, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception
  {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      return new ModelAndView("redirect:/index.do");
    }

    model.addAttribute("username", username);
    model.addAttribute("hideCheckbox", checkbox);
    String errorMsg = getErrorMsg(request, username, model);
    if (errorMsg.equals("密码错误")) {
      model.addAttribute("password", "密码错误");
      model.addAttribute("email", username);
    }
    else if (errorMsg.equals("账号不存在")) {
      model.addAttribute("login", Integer.valueOf(1));
    } else {
      model.addAttribute("login", errorMsg);
      return new ModelAndView("redirect:/login.do");
    }

    return new ModelAndView("login");
  }

  private String getErrorMsg(HttpServletRequest request, String userName, Model model)
    throws Exception
  {
    String msg = "";
    String loginState = (String)request.getAttribute("loginState");
    String loginMessage = (String)request.getAttribute("loginMessage");

    if (loginState != null) {
      if (loginState.equals("2")) {
        msg = "密码错误";
      } else if (loginState.equals("1")) {
        msg = "账号不存在";
        if ((loginMessage != null) && ("baned".equals(loginMessage)))
          msg = "您登录太频繁，请稍后再试!";
      }
      else if (loginState.equals("3")) {
        String lockUserHour = (String)request.getAttribute("lockUserHour");
        msg = "账号被锁定,请在" + lockUserHour + "小时后重试";
      } else if (loginState.equals("4")) {
        msg = "账号未激活";
      } else if (loginState.equals("6")) {
        msg = "系统异常，请稍后再试";
      } else if (loginState.equals("7")) {
        msg = "您的账户已被冻结，详情请致电客服电话：400-9616-588";
      } else {
        msg = (String)request.getAttribute("loginErrorMsg");
        if ((msg == null) || (msg.equals(""))) {
          msg = "验证出现异常，请稍后再试";
        }
      }
    }
    if ((msg == null) || (msg.equals(""))) {
      msg = "后台错误";
    }
    return msg;
  }
}