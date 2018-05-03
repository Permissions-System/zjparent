package com.zjgt.p2p.controller;

import com.zjgt.p2p.model.Agreement;
import com.zjgt.p2p.service.AgreementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/infomag/agreement"})
public class AgreementController
{
  Logger logger = LoggerFactory.getLogger(AgreementController.class);
  final String AGR_REG = "AGR_REG";
  final String AGR_SERVICE_MAG = "AGR_SERVICE_MAG";
  final String AGR_PRO_TRANSFER = "AGR_PRO_TRANSFER";
  final String AGR_NAME_REG = "百富网注册协议";
  final String AGR_NAME_SERVICE_MAG = "百富网投资咨询与管理服务协议";
  final String AGR_NAME_PRO_TRANSFER = "百富网产品转让协议";

  @Autowired
  AgreementService service;
  
  @RequestMapping({"/get"})
  @ResponseBody
  public JsonResponse get(String agreementNo)
  {
    Agreement agrReg = this.service.getByNo(agreementNo);
    JsonResponse jsonResponse = new JsonResponse();
    jsonResponse.setResult(agrReg);
    jsonResponse.setStatus("SUCCESS");
    return jsonResponse;
  }
}