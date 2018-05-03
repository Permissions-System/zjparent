package com.zjgt.p2p.controller;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.model.Bidclass;
import com.zjgt.p2p.model.Cpsrec;
import com.zjgt.p2p.service.BidClassService;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.CpsRegService;
import com.zjgt.util.ImageUtil;
import com.zjgt.util.StringUtil;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{

  @Autowired
  private BidClassService bidClassService;

  @Autowired
  private BidService bidService;

  @Autowired
  private CpsRegService cpsregService;
  Logger logger;

  public IndexController()
  {
    this.logger = LoggerFactory.getLogger(IndexController.class);
  }

  @RequestMapping({"index"})
  public String index(HttpServletRequest request, HttpServletResponse response, Model model, String from) throws IOException
  {
    String channel = request.getParameter(Const.CHANNEL);
    String channel2 = request.getParameter(Const.CHANNEL2);
    if (StringUtil.isNotEmpty(channel))
      request.getSession().setAttribute(Const.CHANNEL, channel);
    else {
      channel = (String)request.getSession().getAttribute(Const.CHANNEL);
    }
    if (StringUtil.isNotEmpty(channel2))
      request.getSession().setAttribute(Const.CHANNEL2, channel2);
    else {
      channel2 = (String)request.getSession().getAttribute(Const.CHANNEL2);
    }
    if (StringUtil.isNotEmpty(channel)) {
      Cpsrec cpsrec = new Cpsrec();
      cpsrec.setChannel(channel);
      cpsrec.setChannel2(channel2);
      cpsrec.setPagename("");
      cpsrec.setUrl(request.getRequestURL().toString());
      cpsrec.setOpdate(new Date());
      this.cpsregService.cpsRec(cpsrec, "registerAjax.do");
    }
    this.logger.info("首页channel:" + channel);
    this.logger.info(request.getRequestURL().toString());
    URL path = ImageUtil.class.getClassLoader().getResource("");
    getImg(path.toString(), model);
    String requestHeader = request.getHeader("user-agent");
    if ((isMobileDevice(requestHeader)) && (!("window".equals(from)))) {
      this.logger.info("使用手机浏览器" + requestHeader);
      response.sendRedirect("http://www.biifoo.com/m");
      return null;
    }
    this.logger.info("使用web浏览器" + requestHeader);

    return "index";
  }

  public boolean isMobileDevice(String requestHeader)
  {
    String[] deviceArray = { "android", "mac os", "windows phone" };

    if (requestHeader == null)
      return false;
    requestHeader = requestHeader.toLowerCase();
    for (int i = 0; i < deviceArray.length; ++i) {
      if (requestHeader.indexOf(deviceArray[i]) > 0) {
        return true;
      }
    }
    return false;
  }

  private void getImg(String path, Model model) {
    Bidclass xinshou = this.bidClassService.selectByPrimaryKey(Long.valueOf(Const.XIN_SHOU_BIAO));

    Bidclass dingcun = this.bidClassService.selectByPrimaryKey(Long.valueOf(Const.DING_CUN_BAO));

    Bidclass yuexi = this.bidClassService.selectByPrimaryKey(Long.valueOf(Const.YUE_XI_BAO));

    Map map = new HashMap();
    map.put("xinshou", xinshou.getBidclasspic());
    map.put("dingcun", dingcun.getBidclasspic());
    map.put("yuexi", yuexi.getBidclasspic());
    model.addAllAttributes(map);
  }

  @RequestMapping({"s1.do"})
  public String s1() {
    return "index/s1";
  }

  @RequestMapping({"s2.do"})
  public String s2() {
    return "index/s2";
  }

  @RequestMapping({"s3.do"})
  public String s3() {
    return "index/s3";
  }

  @RequestMapping({"redadv.do"})
  public String redadv() {
    return "index/redadv";
  }
}