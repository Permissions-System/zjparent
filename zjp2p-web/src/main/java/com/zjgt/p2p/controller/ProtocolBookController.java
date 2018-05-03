package com.zjgt.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProtocolBookController
{
  @RequestMapping({"/contractdebt"})
  public ModelAndView contractdebt(ModelAndView mv)
  {
    mv.setViewName("contract_debt");
    return mv; }

  @RequestMapping({"/contractdd"})
  public ModelAndView contractdd(ModelAndView mv) {
    mv.setViewName("contract_dd");
    return mv; }

  @RequestMapping({"/contractmm"})
  public ModelAndView contractmm(ModelAndView mv) {
    mv.setViewName("contract_mm");
    return mv;
  }
}