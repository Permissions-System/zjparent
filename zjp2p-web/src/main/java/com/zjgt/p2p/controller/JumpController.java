package com.zjgt.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JumpController
{
  @RequestMapping({"/reset_pwd2"})
  public String resetpassword()
  {
    return "reset_pwd2";
  }

  @RequestMapping({"/reset_pwdafter.do"})
  public String resetPassword() {
    return "reset_pwd";
  }

  @RequestMapping({"/member/reg_return.do"})
  public String reg_return() {
    return "reg_return";
  }

  @RequestMapping({"/help_detail.do"})
  public String help_detail() {
    return "service/help_detail";
  }

  @RequestMapping({"/helpcenter.do"})
  public String helpcenter() {
    return "service/helpcenter";
  }

  @RequestMapping({"/safeguard.do"})
  public String safeguard() {
    return "service/safeguard";
  }

  @RequestMapping({"/phoneregister"})
  public String phoneregister() {
    return "phoneregister";
  }

  @RequestMapping({"/mresetsuc"})
  public String mresetsuc(ModelAndView mv) {
    return "mresetsuc";
  }
}