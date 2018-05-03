package com.zjgt.p2p.controller;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.service.BidService;
import com.zjgt.util.Page;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BidControlller
{
  Logger logger;

  @Autowired
  private BidService bidService;

  public BidControlller()
  {
    this.logger = LoggerFactory.getLogger(BidControlller.class);
  }

  @RequestMapping({"queryBidAll"})
  public String getAll(Model model, String bidtypeid, String investperiod, String annualizedrate, String raisestate, String pageNow)
    throws Exception
  {
    Map map = new HashMap();
    map.put("bidtypeid", bidtypeid);
    map.put("investperiod", investperiod);
    map.put("annualizedrate", annualizedrate);
    map.put("raisestate", raisestate);
    map.put("pageNow", pageNow);
    map.put("pageSize", Const.PRODUCTS_PAGE_SIZE + "");
    Page page = this.bidService.getProductsByPage(map);
    model.addAttribute("map", map);
    model.addAttribute("page", page);
    model.addAttribute("bidType", BidType.values());
    return "products_list";
  }

  @RequestMapping({"attention"})
  public String attention(Model model)
    throws Exception
  {
    return "attention";
  }
}