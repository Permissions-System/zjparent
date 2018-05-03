package com.zjgt.p2p.service;

import com.zjgt.p2p.model.VouchOrg;
import com.zjgt.util.Page;
import java.util.List;
import java.util.Map;

public abstract interface VouchOrgService
{
  public abstract VouchOrg findById(String paramString);

  public abstract List<VouchOrg> selectAll();

  public abstract Page<VouchOrg> selectVouchOrgByPage(Map<String, String> paramMap);

  public abstract int addVouchOrg(VouchOrg paramVouchOrg);

  public abstract int updateVouchOrg(VouchOrg paramVouchOrg);

  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract VouchOrg findBybid(String paramString);

  public abstract VouchOrg findByInstcode(String paramString);
}