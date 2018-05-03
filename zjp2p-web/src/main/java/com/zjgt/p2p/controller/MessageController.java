package com.zjgt.p2p.controller;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.model.Message;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.shiro.ShiroMember;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/member"})
public class MessageController
{
  Logger logger;

  @Autowired
  private MessageService messageservice;

  public MessageController()
  {
    this.logger = LoggerFactory.getLogger(MessageController.class);
  }

  @RequestMapping({"/message"})
  public ModelAndView showMessage(ModelAndView mv, HttpServletRequest request)
  {
    mv.setViewName("vip/message");
    return mv;
  }

  @RequestMapping({"/ajaxmessage"})
  @ResponseBody
  public Page<Message> ajaxMessage(String msstatus, String pageNow) {
    this.logger.info("msstatus:" + msstatus + "pageNow:" + pageNow);
    Map map = new HashMap();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    map.put("pageNow", pageNow);
    map.put("ReadStatus", msstatus);
    map.put("Memberid", currUser.getId() + "");
    map.put("pageSize", Const.Message_PAGE_SIZE + "");
    return this.messageservice.getMessageByPage(map);
  }

  @RequestMapping(value={"/message/check"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public JsonResponse checkMessage(String id, HttpServletRequest request) {
    this.logger.info(id);
    if (id != null) {
      this.messageservice.checkMessage(Long.parseLong(id));
      Subject subject = SecurityUtils.getSubject();
      ShiroMember currUser = null;
      if (subject.isAuthenticated()) {
        currUser = (ShiroMember)subject.getPrincipal();
        currUser.subtractUnreadMessageCount();
      }
    }
    JsonResponse jsonResponse = new JsonResponse();
    jsonResponse.setStatus("SUCCESS");
    return jsonResponse;
  }

  @RequestMapping({"/message/delete"})
  @ResponseBody
  public Page<Message> deleteMessage(String id, String msstatus, String pageNow, HttpServletRequest request) {
    this.logger.info("msstatus:" + msstatus + "pageNow:" + pageNow);
    Map map = new HashMap();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if (StringUtils.isNotEmpty(id)) {
      Message message = this.messageservice.getMessageById(Long.valueOf(id).longValue());

      if (message.getStatus().intValue() == 1) {
        currUser.subtractUnreadMessageCount();
      }
    }
    map.put("pageNow", pageNow);
    map.put("ReadStatus", msstatus);
    map.put("Memberid", currUser.getId() + "");
    map.put("pageSize", Const.Message_PAGE_SIZE + "");
    return this.messageservice.deleteMessage(Long.parseLong(id), map);
  }
}