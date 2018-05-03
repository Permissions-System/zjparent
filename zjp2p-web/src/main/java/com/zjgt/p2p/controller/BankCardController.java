package com.zjgt.p2p.controller;

import com.zjgt.p2p.base.service.ICodeInfoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankCardController
{

  @Autowired
  private ICodeInfoService codeInfoService;

  @RequestMapping({"/member/getPrinces"})
  @ResponseBody
  public JsonResponse getPrinces()
  {
    JsonResponse jsonResponse = new JsonResponse();
    Map params = new HashMap();

    params.put("typeCode", "llCityCode_");

    Page pageList = this.codeInfoService.getTypeCodeListByPage(params, 1, 2147483647);
    List detailList = pageList.getResult();
    jsonResponse.setResult(detailList);
    jsonResponse.setStatus("SUCCESS");
    return jsonResponse;
  }

  @RequestMapping({"/member/getCitys"})
  @ResponseBody
  public JsonResponse getCitys(String princeName) {
    JsonResponse jsonResponse = new JsonResponse();

    String typeCode = "llCityCode_" + princeName;

    List codelist = this.codeInfoService.getCodeInfoListByTypeCode(typeCode);
    jsonResponse.setResult(codelist);
    jsonResponse.setStatus("SUCCESS");
    return jsonResponse;
  }

  @RequestMapping({"/member/getPayBanks"})
  @ResponseBody
  public JsonResponse getPayBanks() {
    JsonResponse jsonResponse = new JsonResponse();

    String typeCode = "PAY_BANK_LIST_LL";

    List codelist = this.codeInfoService.getCodeInfoListByTypeCode(typeCode);
    jsonResponse.setResult(codelist);
    jsonResponse.setStatus("SUCCESS");
    return jsonResponse;
  }
}