package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;
import org.springfk.pancloud.paginator.vo.Page;

@PanCloudDaoRepository
public abstract interface TransactionDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Transaction paramTransaction);

  public abstract Transaction selectByPrimaryKey(String paramString);

  public abstract int updateByPrimaryKey(Transaction paramTransaction);

  public abstract List<Transaction> selectTransByModuleCode(String paramString);

  public abstract int findCountByTransCode(String paramString);

  public abstract int findCountByTransName(String paramString);

  public abstract List<Transaction> getTransByPage(Map<String, Object> paramMap, Page<Transaction> paramPage);

  public abstract List<Transaction> getTransByModuleCodePage(Map<String, Object> paramMap);

  public abstract List<Transaction> selectByModulesAndPage(Map<String, Object> paramMap);
}