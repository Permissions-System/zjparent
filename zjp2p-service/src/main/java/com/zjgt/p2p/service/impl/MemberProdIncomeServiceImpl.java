package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.dao.MemberProdIncomeMapper;
import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.model.MemberProdIncomeExample;
import com.zjgt.p2p.model.MemberProdIncomeExample.Criteria;
import com.zjgt.p2p.service.MemberProdIncomeService;
import com.zjgt.p2p.viewbean.InvestdocView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberProdIncomeServiceImpl
  implements MemberProdIncomeService
{

  @Autowired
  private MemberProdIncomeMapper mapper;

  public List<InvestdocView> getMemberProdIncome(long memberid)
  {
    BigDecimal allamount = getAmount(memberid);
    List investdocviews = new ArrayList();
    BidType[] values = BidType.values();
    for (int i = 0; i < values.length; ++i) {
      String value = values[i].getValue();
      int key = values[i].getKey();
      InvestdocView idv = new InvestdocView();
      MemberProdIncomeExample exam = new MemberProdIncomeExample();
      exam.createCriteria().andMemberidEqualTo(Long.valueOf(memberid)).andBidtypeidEqualTo(Integer.valueOf(key));

      List memberprodincomes = this.mapper.selectByExample(exam);

      Iterator it = memberprodincomes.iterator();
      BigDecimal bidtypeamount = new BigDecimal(0);
      while (it.hasNext()) {
        bidtypeamount = bidtypeamount.add(((MemberProdIncome)it.next()).getIncome());
      }
      idv.setAmount(bidtypeamount);
      idv.setBidclassname(value);

      idv.setAllamount(allamount);
      investdocviews.add(idv);
    }
    if (investdocviews.size() == 4) {
      ((InvestdocView)investdocviews.get(0)).setColor("#F3C600");
      ((InvestdocView)investdocviews.get(1)).setColor("#009CE4");
      ((InvestdocView)investdocviews.get(2)).setColor("#EA544A");
      ((InvestdocView)investdocviews.get(3)).setColor("#3DB236");
    }
    return investdocviews;
  }

  public BigDecimal getAmount(long memberid) {
    BigDecimal amount = BigDecimal.valueOf(0L);
    amount = this.mapper.getSumAmount(memberid);
    return amount;
  }

  public void addProductIncome(MemberProdIncome prodIncome)
  {
    MemberProdIncomeExample example = new MemberProdIncomeExample();
    example.createCriteria().andMemberidEqualTo(prodIncome.getMemberid()).andBidtypeidEqualTo(prodIncome.getBidtypeid());

    List list = this.mapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty())))
      this.mapper.updateByPrimaryKeySelective(prodIncome);
    else
      this.mapper.insertSelective(prodIncome);
  }

  public MemberProdIncome selectBytype(long memberid, Integer bidtypeid)
  {
    MemberProdIncomeExample example = new MemberProdIncomeExample();
    example.createCriteria().andMemberidEqualTo(Long.valueOf(memberid)).andBidtypeidEqualTo(bidtypeid);

    List list = this.mapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((MemberProdIncome)list.get(0));
    }
    return null;
  }
}