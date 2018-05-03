package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.YieldplanMapper;
import com.zjgt.p2p.dao.YieldsumMapper;
import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.YieldplanExample;
import com.zjgt.p2p.model.YieldplanExample.Criteria;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.model.YieldsumExample;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.YieldCommission;
import com.zjgt.p2p.service.YieldplanService;
import com.zjgt.p2p.service.YieldsumService;
import java.math.BigDecimal;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("yieldCommissionImpl")
public class YieldCommissionImpl
  implements YieldCommission
{

  @Autowired
  private AgentService agentService;

  @Autowired
  private YieldsumMapper yieldsumdao;

  @Autowired
  private YieldplanMapper yieldplandao;

  @Autowired
  private YieldplanService yieldplanService;

  @Autowired
  private YieldsumService yieldsumService;

  @Autowired
  private MemberService memberService;

  @Transactional
  public void generatorCommissionPlan(String investOrderCode, Long memberid)
    throws BusinessException
  {
    Agent agent = this.agentService.selectByInvitee(memberid);
    Yieldsum yieldsum = null;
    if (agent == null)
      return;
    if ((agent.getIsMerchant() != null) && 
      (agent.getIsMerchant().intValue() == 1)) {
      return;
    }

    BigDecimal commission = agent.getCommissionrate();
    if (commission.compareTo(new BigDecimal(0)) == 1) {
      YieldsumExample sumExample = new YieldsumExample();
      sumExample.createCriteria().andMemberidEqualTo(Integer.valueOf(memberid.intValue())).andInvestordercodeEqualTo(investOrderCode);

      List yieldsums = this.yieldsumdao.selectByExample(sumExample);

      YieldplanExample planExample = new YieldplanExample();
      planExample.createCriteria().andMemberidEqualTo(Integer.valueOf(memberid.intValue())).andInvestordercodeEqualTo(investOrderCode);

      List<Yieldplan> yieldplans = this.yieldplandao.selectByExample(planExample);

      for (Yieldplan plan : yieldplans) {
        plan.setTermamount(plan.getAccruedinterest().multiply(commission));
        plan.setAccruedinterest(plan.getAccruedinterest().multiply(commission));
        plan.setRemaininterest(plan.getRemaininterest().multiply(commission));
        plan.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
        plan.setParentid(plan.getId());
        plan.setId(null);
        plan.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
        this.yieldplandao.insertSelective(plan);
      }
      if ((yieldsums != null) && (!(yieldsums.isEmpty()))) {
        yieldsum = (Yieldsum)yieldsums.get(0);
        yieldsum.setTermamount(yieldsum.getAccruedinterestsum().multiply(commission));
        yieldsum.setAccruedinterestsum(yieldsum.getAccruedinterestsum().multiply(commission));
        yieldsum.setRemaininterestsum(yieldsum.getRemaininterestsum().multiply(commission));
        yieldsum.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
        yieldsum.setParentid(yieldsum.getId());
        yieldsum.setId(null);
        yieldsum.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
        this.yieldsumdao.insertSelective(yieldsum);
      }
    }
  }

  @Transactional
  public int updateCommissionPlan(List<Yieldplan> planList, Yieldsum yieldsum)
  {
    int sum = 0;
    sum = updateCommissionPlan(planList);
    updateCommissionPlan(yieldsum);
    return sum;
  }

  public int updateCommissionPlan(List<Yieldplan> planList) {
    int sum = 0;
    for (Yieldplan plan : planList) {
      sum += updateCommissionPlan(plan);
    }
    return sum;
  }

  public int updateCommissionPlan(Yieldplan plan)
  {
    if (plan == null) {
      return 0;
    }
    Agent agent = this.agentService.selectByInvitee(Long.valueOf(plan.getMemberid().longValue()));
    if (agent == null) {
      return 0;
    }
    BigDecimal commission = agent.getCommissionrate();
    if (commission.compareTo(new BigDecimal(0)) < 1) {
      return 0;
    }
    Yieldplan yieldplan = this.yieldplandao.findCommissionByParent(plan.getId());
    if (yieldplan == null) {
      return 0;
    }
    plan.setTermamount(plan.getAccruedinterest().multiply(commission));
    plan.setAccruedinterest(plan.getAccruedinterest().multiply(commission));
    plan.setRemaininterest(plan.getRemaininterest().multiply(commission));
    plan.setRepaidamount(plan.getRepaidamount().remainder(new BigDecimal(100)));
    plan.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
    plan.setParentid(plan.getId());
    plan.setId(yieldplan.getId());
    plan.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
    return this.yieldplandao.updateByPrimaryKeySelective(plan);
  }

  public void updateCommissionPlanByTiantianfu(Yieldplan plan, Yieldsum yieldsum) {
    if (plan == null) {
      return;
    }
    Agent agent = this.agentService.selectByInvitee(Long.valueOf(plan.getMemberid().longValue()));
    if (agent == null) {
      return;
    }

    if ((agent.getIsMerchant() != null) && 
      (agent.getIsMerchant().intValue() == 1)) {
      return;
    }

    BigDecimal commission = agent.getCommissionrate();
    if (commission.compareTo(new BigDecimal(0)) < 1) {
      return;
    }
    Yieldplan yieldplan = this.yieldplandao.findCommissionByParent(plan.getId());
    plan.setTermamount(plan.getAccruedinterest().multiply(commission));
    plan.setAccruedinterest(plan.getAccruedinterest().multiply(commission));
    plan.setRemaininterest(plan.getRemaininterest().multiply(commission));
    plan.setRepaidamount(plan.getRepaidamount().remainder(new BigDecimal(100)));
    plan.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
    plan.setParentid(plan.getId());
    if (yieldplan == null)
      plan.setId(null);
    else {
      plan.setId(yieldplan.getId());
    }
    plan.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
    this.yieldplanService.savePlan(plan);

    Yieldsum yieldsumcomm = this.yieldsumdao.findCommissionByParent(yieldsum.getId());
    yieldsum.setTermamount(yieldsum.getAccruedinterestsum().multiply(commission));
    yieldsum.setAccruedinterestsum(yieldsum.getAccruedinterestsum().multiply(commission));
    yieldsum.setRemaininterestsum(yieldsum.getRemaininterestsum().multiply(commission));
    yieldsum.setRepaidamountsum(yieldsum.getRepaidinterestsum().multiply(commission));
    yieldsum.setRemaininterestsum(yieldsum.getRepaidinterestsum().multiply(commission));
    yieldsum.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
    yieldsum.setParentid(yieldsum.getId());
    if (yieldplan == null)
      yieldsum.setId(null);
    else {
      yieldsum.setId(yieldsumcomm.getId());
    }
    yieldsum.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
    this.yieldsumService.saveYieldsum(yieldsum);
  }

  public void updateCommissionPlan(Yieldsum yieldsum) {
    if (yieldsum == null) {
      return;
    }
    Agent agent = this.agentService.selectByInvitee(Long.valueOf(yieldsum.getMemberid().longValue()));
    if (agent == null) {
      return;
    }
    BigDecimal commission = agent.getCommissionrate();
    if (commission.compareTo(new BigDecimal(0)) < 1) {
      return;
    }
    Yieldsum yieldsumcomm = this.yieldsumdao.findCommissionByParent(yieldsum.getId());
    if (yieldsumcomm == null) {
      return;
    }
    yieldsum.setTermamount(yieldsum.getAccruedinterestsum().multiply(commission));
    yieldsum.setAccruedinterestsum(yieldsum.getAccruedinterestsum().multiply(commission));
    yieldsum.setRemaininterestsum(yieldsum.getRemaininterestsum().multiply(commission));
    yieldsum.setRepaidamountsum(yieldsum.getRepaidinterestsum().multiply(commission));
    yieldsum.setRemaininterestsum(yieldsum.getRepaidinterestsum().multiply(commission));
    yieldsum.setMemberid(Integer.valueOf(agent.getMemberid().intValue()));
    yieldsum.setParentid(yieldsum.getId());
    yieldsum.setId(yieldsumcomm.getId());
    yieldsum.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
    this.yieldsumdao.updateByPrimaryKeySelective(yieldsum);
  }
}