package com.zjgt.thirdpay.util;

import com.zjgt.thirdpay.domain.SinaPayRequest;
import com.zjgt.thirdpay.sign.SignAndVerify;
import com.zjgt.thirdpay.v2.domain.InstantOrderRequest;
import com.zjgt.util.PropertiesUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Iterator;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormGenerator
{

  @Autowired
  private SignAndVerify signAndVerify;

  public String generateForm(SinaPayRequest spr)
  {
    Validate.notNull(spr, "request is null", new Object[0]);
    spr.setSignType(Constants.signType);
    String signContent = spr.generateSignContent();
    try {
      String signMsg = this.signAndVerify.sign(signContent);
      spr.setSignMsg(signMsg);
    } catch (InvalidKeyException e) {
      throw new RuntimeException("invalid key", e);
    } catch (SignatureException e) {
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Algorithm not supported", e);
    }

    BeanMap params = new BeanMap(spr);
    StringBuilder formBuilder = new StringBuilder();
    formBuilder.append(new StringBuilder().append("<form id=\"").append(Constants.getFormElementId()).append("\" action=\"").append(Constants.getActionUrl()).append("\" method=\"post\">\r\n").toString());

    Iterator keyIterator = params.keyIterator();
    while (keyIterator.hasNext()) {
      String propertyName = (String)keyIterator.next();
      Object value = params.get(propertyName);
      if ((value != null) && (value instanceof String)) {
        formBuilder.append("<input type=\"hidden\" name=\"").append(propertyName).append("\" value=\"");
        formBuilder.append(StringEscapeUtils.escapeHtml4((String)value)).append("\" />\r\n");
      }
    }
    formBuilder.append("</form>");
    return formBuilder.toString();
  }

  public String generateForm(InstantOrderRequest request, String input_charset) {
    BeanMap params = new BeanMap(request);
    String html = null;
    try {
      html = new StringBuilder().append("<form id=\"recvForm\" action=\"").append(PropertiesUtils.getProperties("pay.v2.rechargeActionUrl")).append("\" method=\"post\">\r\n").toString();
    } catch (Exception e1) {
      e1.printStackTrace();
    }

    Iterator keyIterator = params.keyIterator();
    while (keyIterator.hasNext()) {
      String propertyName = (String)keyIterator.next();
      if (params.get(propertyName) instanceof String) {
        String value = (String)params.get(propertyName);
        try {
          if ((value != null) && (value instanceof String))
            html = new StringBuilder().append(html).append("<input type='hidden' name='").append(propertyName).append("' value='").append(URLEncoder.encode(value, input_charset)).append("'/>\r\n").toString();
        }
        catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
    }
    html = new StringBuilder().append(html).append("</form>").toString();
    return html;
  }
}