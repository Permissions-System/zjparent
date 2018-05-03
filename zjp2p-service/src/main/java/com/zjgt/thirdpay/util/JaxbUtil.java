package com.zjgt.thirdpay.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil
{
  public static String convertToXml(Object obj)
  {
    return convertToXml(obj, "UTF-8");
  }

  public static String convertToXml(Object obj, String encoding)
  {
    String result = null;
    try {
      JAXBContext context = JAXBContext.newInstance(new Class[] { obj.getClass() });
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      marshaller.setProperty("jaxb.encoding", encoding);

      StringWriter writer = new StringWriter();
      marshaller.marshal(obj, writer);
      result = writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }

  public static <T> T converyToJavaBean(String xml, Class<T> c)
  {
    Object t = null;
    try {
      JAXBContext context = JAXBContext.newInstance(new Class[] { c });
      Unmarshaller unmarshaller = context.createUnmarshaller();
      t = unmarshaller.unmarshal(new StringReader(xml));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return (T) t;
  }
}