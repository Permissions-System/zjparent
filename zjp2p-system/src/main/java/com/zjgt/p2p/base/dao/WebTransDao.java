package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.WebTrans;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface WebTransDao
{
  public abstract void insert(WebTrans paramWebTrans);

  public abstract void update(WebTrans paramWebTrans);

  public abstract void delete(String paramString);

  public abstract WebTrans getWebTransInfo(String paramString);

  public abstract int getCountWebTransInfo(String paramString);

  public abstract Integer getRecheckLevel(String paramString);

  public abstract String getRecheckDetailPage(String paramString);

  public abstract String getRecheckHandlePage(String paramString);

  public abstract List<WebTrans> getWebTransInfoListByProductCode(String paramString);

  public abstract List<WebTrans> getWebTransInfoListByPage(Map<String, Object> paramMap);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.WebTransDao
 * JD-Core Version:    0.5.3
 */