package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Message;
import java.util.Map;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface MessageService
{
  public abstract Page<Message> getMessageByPage(Map<String, String> paramMap);

  public abstract Message getMessageById(long paramLong);

  public abstract int checkMessage(long paramLong);

  public abstract Page<Message> deleteMessage(long paramLong, Map<String, String> paramMap);

  public abstract int getUnreadMessageCount(long paramLong);

  public abstract boolean sendMessage(String paramString, long paramLong, String[] paramArrayOfString);

  public abstract void paymentPreNotice();
}