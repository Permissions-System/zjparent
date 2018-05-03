package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.LoginLocale;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface LoginLocaleDao
{
  public abstract int insert(LoginLocale paramLoginLocale);

  public abstract void update(LoginLocale paramLoginLocale);

  public abstract List<LoginLocale> selectAll();

  public abstract LoginLocale getLoginLocaleByUserNoAndLocale(@Param("userNo") String paramString1, @Param("locale") String paramString2);

  public abstract List<LoginLocale> selectByUserNo(String paramString);

  public abstract List<LoginLocale> getLoginLocaleGreaterThanThreshold(@Param("userNo") String paramString, @Param("threshold") int paramInt);
}