package com.zjgt.p2p.controller;

import com.zjgt.util.RichManBean;
import com.zjgt.util.RichManUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RichManController
{
  Logger logger;

  public RichManController()
  {
    this.logger = LoggerFactory.getLogger(RichManController.class);
  }

  @RequestMapping({"/richman"})
  public String richman(Model model, HttpServletResponse response)
  {
    return "richman";
  }

  @RequestMapping({"/countWorth"})
  @ResponseBody
  public JsonResponse countWorth(Model model, HttpServletResponse response, HttpServletRequest request, @RequestParam("deposit") String deposit, @RequestParam("monthIn") String monthIn, @RequestParam("investRate") String investRate, @RequestParam("year") String year)
  {
    RichManBean man = new RichManBean();
    man.setDeposit(Double.valueOf(deposit).doubleValue());
    man.setMonthIn(Double.valueOf(monthIn).doubleValue());
    man.setInvestRate(Double.valueOf(investRate).doubleValue());
    man.setYear(Integer.valueOf(year).intValue());
    man.setIncomeRate(10.0D);
    man.setMonthIncrease(10.0D);
    RichManUtil.countWorth(man);
    JsonResponse jsonResponse = new JsonResponse();
    jsonResponse.setResult(Integer.valueOf((int)RichManUtil.countWorth(man)));
    return jsonResponse;
  }
}