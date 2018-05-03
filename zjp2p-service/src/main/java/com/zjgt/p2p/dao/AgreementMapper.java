package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Agreement;
import com.zjgt.p2p.model.AgreementExample;
import java.util.List;

public abstract interface AgreementMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(Agreement paramAgreement);

  public abstract int insertSelective(Agreement paramAgreement);

  public abstract List<Agreement> selectByExample(AgreementExample paramAgreementExample);

  public abstract Agreement selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(Agreement paramAgreement);

  public abstract int updateByPrimaryKey(Agreement paramAgreement);
}