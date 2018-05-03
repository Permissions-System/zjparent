package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.TermStatus;
import com.zjgt.p2p.dao.MessageMapper;
import com.zjgt.p2p.dao.YieldplanMapper;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Message;
import com.zjgt.p2p.model.MessageExample;
import com.zjgt.p2p.model.MessageExample.Criteria;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.YieldplanExample;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.InvestOrderService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.StringUtil;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl
  implements MessageService
{

  @Autowired
  private MessageMapper mapper;

  @Autowired
  private InvestOrderService investOrderService;

  @Autowired
  private BidService bidService;
  Logger logger;

  @Autowired
  private YieldplanMapper yieldplandao;

  public MessageServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(MessageServiceImpl.class);
  }

  public Page<Message> getMessageByPage(Map<String, String> map)
  {
    Page pages = null;
    int pageNow = 0;
    MessageExample exam = new MessageExample();
    MessageExample.Criteria crit = exam.createCriteria();
    if (map.get("ReadStatus") != null) {
      if (Integer.parseInt((String)map.get("ReadStatus")) != 0) {
        crit.andStatusEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("ReadStatus"))));
      } else {
        List status = new ArrayList();
        status.add(Integer.valueOf(1));
        status.add(Integer.valueOf(2));
        crit.andStatusIn(status);
      }
    }
    if ((map.get("Memberid") != null) && 
      (StringUtil.isNotEmpty((String)map.get("Memberid")))) {
      crit.andMemberidEqualTo(Long.valueOf(Long.parseLong((String)map.get("Memberid"))));
    }

    exam.setOrderByClause("createdate desc");
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setPage(pages);
    pages.setResult(this.mapper.selectByExample(exam));
    return pages;
  }

  public Message getMessageById(long id) {
    return this.mapper.selectByPrimaryKey(Long.valueOf(id));
  }

  public Page<Message> deleteMessage(long id, Map<String, String> map) {
    Message message = new Message();
    message.setStatus(Integer.valueOf(3));
    message.setId(Long.valueOf(id));
    this.mapper.updateByPrimaryKeySelective(message);
    return getMessageByPage(map);
  }

  public int getUnreadMessageCount(long id)
  {
    MessageExample exam = new MessageExample();
    exam.createCriteria().andMemberidEqualTo(Long.valueOf(id)).andStatusEqualTo(Integer.valueOf(1));
    return this.mapper.selectByExample(exam).size();
  }

  public boolean sendMessage(String mess, long memberId, String[] messages) {
    Message message = new Message();
    message.setMemberid(Long.valueOf(memberId));
    message.setStatus(Integer.valueOf(1));
    message.setCreatedate(new Date());
    try {
      String title = PropertiesUtils.getPropertiesByMessage(mess + ".title");
      message.setTitle(title);
      message.setType(Integer.valueOf(1));
      message.setContent(MessageFormat.format(PropertiesUtils.getPropertiesByMessage(mess + ".context"), messages));
      this.mapper.insertSelective(message);
    } catch (Exception e) {
      this.logger.error("sendMessage MessageFormat error", e);
      return false;
    }
    return true;
  }

  public int checkMessage(long id)
  {
    Message message = new Message();
    message.setStatus(Integer.valueOf(2));
    message.setId(Long.valueOf(id));
    return this.mapper.updateByPrimaryKeySelective(message);
  }

  @Transactional
  public void paymentPreNotice() throws BusinessException {
    paymentPreNotice(new Date());
  }

  @Transactional
  public int paymentPreNotice(Date currentDate)
    throws BusinessException
  {
    YieldplanExample exam = new YieldplanExample();
    List<Yieldplan> list = this.yieldplandao.selectByExample(exam);
    if ((list != null) && (!(list.isEmpty()))) {
      for (Yieldplan plan : list) {
        if ((StringUtil.isEmpty(plan.getTermstatus())) || (!(String.valueOf(TermStatus.REPAYED.getKey()).equals(plan.getTermstatus()))))
        {
          if ((plan.getTermdate() != null) || (!(StringUtil.isEmpty(plan.getTermstatus()))))
          {
            Calendar cl = Calendar.getInstance();
            cl.setTime(plan.getTermdate());
            cl.add(5, -2);
            if ((DateConverterUtil.areSameDay(cl.getTime(), currentDate)) && (String.valueOf(TermStatus.REPAYING.getKey()).equals(plan.getTermstatus()))) {
              this.logger.info(plan.getInvestordercode() + "还款通知,还款日:" + cl.getTime().toString() + ",当前时间:" + currentDate.toString());

              InvestOrder investOrder = this.investOrderService.findByOrdercode(plan.getInvestordercode());
              Bid investOrderBid = this.bidService.findByBidcode(investOrder.getBidcode());
              sendMessage("message.paymentPre", plan.getMemberid().intValue(), new String[] { investOrderBid.getBidclassname(), DateUtils.formatDate(plan.getTermdate(), "yyyy年MM月dd"), String.valueOf(investOrder.getAmount()), String.valueOf(investOrder.getExptincome()) });
            }
          }
        }
      }
    }
    else {
      return 0;
    }
    return 1;
  }
}