package com.zjgt.p2p;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler
  implements HandlerExceptionResolver
{
  private String defaultErrorView;
  private Properties exceptionMappings;

  public String getDefaultErrorView()
  {
    return this.defaultErrorView;
  }

  public void setDefaultErrorView(String defaultErrorView) {
    this.defaultErrorView = defaultErrorView;
  }

  public Properties getExceptionMappings() {
    return this.exceptionMappings;
  }

  public void setExceptionMappings(Properties exceptionMappings) {
    this.exceptionMappings = exceptionMappings;
  }

  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
  {
    ex.printStackTrace();
    Map<String, Exception> model = new HashMap<String, Exception>();
    model.put("ex", ex);

    return new ModelAndView("error", model);
  }
}