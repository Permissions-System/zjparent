package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.VouchOrg;
import com.zjgt.p2p.model.VouchOrgExample;
import java.util.List;

public abstract interface VouchOrgMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(VouchOrg paramVouchOrg);

  public abstract int insertSelective(VouchOrg paramVouchOrg);

  public abstract List<VouchOrg> selectByExample(VouchOrgExample paramVouchOrgExample);

  public abstract VouchOrg selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(VouchOrg paramVouchOrg);

  public abstract int updateByPrimaryKey(VouchOrg paramVouchOrg);

  public abstract List<VouchOrg> selectByExampleLimit(VouchOrgExample paramVouchOrgExample);

  public abstract int getVouchOrgCount(VouchOrgExample paramVouchOrgExample);
}