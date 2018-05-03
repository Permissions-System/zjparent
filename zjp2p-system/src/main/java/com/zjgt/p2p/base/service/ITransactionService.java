package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface ITransactionService
{
  public abstract void addTransaction(Transaction paramTransaction)
    throws BusinessException;

  public abstract void updateTransaction(Transaction paramTransaction)
    throws BusinessException;

  public abstract void deleteTransaction(String paramString)
    throws BusinessException;

  public abstract Transaction getTransactionByTransCode(String paramString)
    throws BusinessException;

  public abstract List<Transaction> getTransByModuleCode(String paramString)
    throws BusinessException;

  public abstract boolean checkTransCode(String paramString)
    throws BusinessException;

  public abstract boolean checkTransName(String paramString)
    throws BusinessException;

  public abstract Page<Transaction> getTransByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract Page<Transaction> getTransByModuleCodeAndPage(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2)
    throws BusinessException;

  public abstract Page<Transaction> getTransByModuleCodePage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.ITransactionService
 * JD-Core Version:    0.5.3
 */