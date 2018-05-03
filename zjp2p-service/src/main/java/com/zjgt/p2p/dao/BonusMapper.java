package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Bonus;
import com.zjgt.p2p.model.BonusExample;
import java.util.List;
import java.util.Map;

public abstract interface BonusMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(Bonus paramBonus);

  public abstract int insertSelective(Bonus paramBonus);

  public abstract List<Bonus> selectByExample(BonusExample paramBonusExample);

  public abstract List<Map<String, Object>> selectUseList(Map<String, Object> paramMap);

  public abstract Bonus selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(Bonus paramBonus);

  public abstract int updateByPrimaryKey(Bonus paramBonus);

  public abstract List<Bonus> selectByMap(Map<String, Object> paramMap);
}