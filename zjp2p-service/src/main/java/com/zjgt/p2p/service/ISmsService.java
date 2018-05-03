package com.zjgt.p2p.service;

public abstract interface ISmsService
{
  public abstract void send(String paramString1, String paramString2)
    throws Exception;

  public abstract void sendMessageByTemplet(String paramString1, String paramString2)
    throws Exception;
}