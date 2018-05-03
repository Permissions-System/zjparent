package com.zjgt.p2p.controller;

import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.BonusType;
import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.Bonus;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.BonusService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.shiro.ShiroMember;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springfk.pancloud.domain.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/member"})
public class ReferralController
{

  @Autowired
  private BonusService bonusService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private AgentService agentService;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private MemberAccountService memberAccountService;

  @RequestMapping({"/referral"})
  public String getBonusInfo(Model model)
  {
    Map bonusmap = new HashMap();
    Map accountmap = new HashMap();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    int num = 0;
    BigDecimal sum = BigDecimal.ZERO;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    boolean flag = this.agentService.isMiddleman(currUser.getId());
    Agent agent = this.agentService.selectByMemberid(currUser.getId());
    MemberAcct acct = this.memberAcctService.findByMemberIdForUpdate(currUser.getId(), Integer.valueOf(AcctType.COMMISSION.getKey()));
    MemberAccount account = this.memberAccountService.getByMemberId(currUser.getId());
    bonusmap.put("memberid", currUser.getId() + "");
    bonusmap.put("bonustype", Integer.valueOf(BonusType.TUIJIANHONGBAO.getKey()));
    List<Bonus> list = this.bonusService.getBonusCountInfo(bonusmap);
    accountmap = this.memberService.getSumAccount(currUser.getId());
    for (Bonus bonus : list) {
      ++num;
      sum = sum.add(bonus.getAccount());
    }
    model.addAttribute("num", Integer.valueOf(num));
    model.addAttribute("sum", sum);
    model.addAttribute("accountmap", accountmap);
    model.addAttribute("acct", acct);
    model.addAttribute("account", account);
    model.addAttribute("flag", Boolean.valueOf(flag));
    model.addAttribute("agent", agent);
    return "vip/referral";
  }

  @RequestMapping({"referral_2"})
  public String referral_2() {
    return "vip/referral_2";
  }

  @RequestMapping({"becomeMiddle"})
  @ResponseBody
  public JsonResponse becomeMiddle() {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }

    boolean flag = this.agentService.isMiddleman(currUser.getId());
    if (flag) {
      jsonResponse.setStatus("2");
      jsonResponse.setMsg("你已经成为经纪人");
    } else {
      int status = this.agentService.becomeMiddleman(currUser.getId());
      if (status == 1) {
        jsonResponse.setStatus("SUCCESS");
        jsonResponse.setMsg("你成功成为经纪人");
      }
      if (status == 0) {
        jsonResponse.setStatus("FAIL");
        jsonResponse.setMsg("你申请失败");
      }
    }
    return jsonResponse;
  }
}