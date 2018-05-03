package com.zjgt.p2p.controller.util;

import com.zjgt.p2p.common.BidType;
import com.zjgt.shiro.ShiroMember;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.kit.PathKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class GenPdfUtil
{
  private Logger logger;

  @Autowired
  private FreeMarkerConfigurer freeMarkerConfigurer;

  public GenPdfUtil()
  {
    this.logger = LoggerFactory.getLogger(GenPdfUtil.class);

    this.freeMarkerConfigurer = null;
  }

  public boolean genPdf(Map<String, Object> paramMap, BidType bidType, int type, String investordercode)
  {
    String savePath;
    if (0 == type)
    {
      savePath = new StringBuilder().append(PathKit.getWebRootPath()).append("/static/upload/buyprotocol/").append(BidType.MINGXINGBIAO.getKey()).append("/").toString();
      return genPdf(paramMap, savePath, "contract_dd.ftl", investordercode); }
    if (1 == type) {
      savePath = new StringBuilder().append(PathKit.getWebRootPath()).append("/static/upload/buyprotocol/").append(BidType.YUEXIBAO.getKey()).append("/").toString();
      return genPdf(paramMap, savePath, "contract_mm.ftl", investordercode); }
    if (2 == type) {
      savePath = new StringBuilder().append(PathKit.getWebRootPath()).append("/static/upload/buyprotocol/").append(BidType.YUEXIBAO.getKey()).append("/debt_").toString();
      genPdf(paramMap, savePath, "contract_debt.ftl", investordercode);
    }
    return false;
  }

  public boolean genPdf(Map<String, Object> paramMap, String savePath, String templateFileName, String investordercode)
  {
    String fileName = null;
    try
    {
      Configuration cfg = this.freeMarkerConfigurer.getConfiguration();

      Template temp = cfg.getTemplate(templateFileName);
      Subject subject = SecurityUtils.getSubject();
      String userId = null;
      ShiroMember currUser = null;
      if (subject.isAuthenticated()) {
        currUser = (ShiroMember)subject.getPrincipal();
        userId = String.valueOf(currUser.getId());
      }

      fileName = new StringBuilder().append(userId).append("_").append(investordercode).append(".pdf").toString();
      File folderFile = new File(savePath);
      if (!(folderFile.exists()))
      {
        folderFile.mkdirs();
      }
      this.logger.info(new StringBuilder().append("savePath:").append(savePath).append(fileName).toString());
      OutputStream os = new FileOutputStream(new StringBuilder().append(savePath).append(fileName).toString());
      CharArrayWriter out = new CharArrayWriter();
      Map root = new HashMap();
      root.put("obj", paramMap);
      temp.process(root, out);

      ITextRenderer renderer = new ITextRenderer();
      renderer.setDocumentFromString(out.toString());

      ITextFontResolver fontResolver = renderer.getFontResolver();
      String fontFilePath = new StringBuilder().append(PathKit.getWebRootPath()).append("/static/fonts/simsun.ttf").toString();
      this.logger.debug(new StringBuilder().append("simsun.ttf path:").append(fontFilePath).toString());
      fontResolver.addFont(fontFilePath, "Identity-H", false);
      renderer.layout();
      renderer.createPDF(os);
      os.close();
      return true;
    } catch (Exception e) {
      this.logger.error(new StringBuilder().append("生成协议书报错 , savePath=").append(savePath).append(fileName).append(",investordercode=").append(investordercode).append(",templateFileName=").append(templateFileName).append(",paramMap=").append((paramMap == null) ? null : paramMap.toString()).toString(), e);
    }

    return false;
  }
}