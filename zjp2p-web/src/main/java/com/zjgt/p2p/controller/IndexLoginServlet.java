package com.zjgt.p2p.controller;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexLoginServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    response.setContentType("text/html;charset=utf-8");
    try {
      response.sendRedirect(new Oauth().getAuthorizeURL(request));
    } catch (QQConnectException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    doGet(request, response);
  }
}