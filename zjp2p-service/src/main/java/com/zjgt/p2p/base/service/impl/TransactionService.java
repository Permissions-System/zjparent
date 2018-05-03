package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.TransactionDao;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.ITransactionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransactionService
  implements ITransactionService
{

  @Autowired
  private TransactionDao transactionDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  private void validateTransaction(Transaction transaction)
  {
    Set result = this.validator.validate(transaction, new Class[0]);
    if (result.isEmpty()) {
      return;
    }

    BusinessException ex = new BusinessException("数据校验错误");
    ex.setErrorMessages(result);
    throw ex;
  }

  public void addTransaction(Transaction transaction)
    throws BusinessException
  {
    validateTransaction(transaction);
    try {
      this.transactionDao.insert(transaction);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRTJ01", null, e));
    }
  }

  public void updateTransaction(Transaction transaction)
    throws BusinessException
  {
    validateTransaction(transaction);
    try {
      this.transactionDao.updateByPrimaryKey(transaction);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRXG01", null, e));
    }
  }

  public void deleteTransaction(String transCode)
    throws BusinessException
  {
    try
    {
      this.transactionDao.deleteByPrimaryKey(transCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRSC01", null, e));
    }
  }

  public Transaction getTransactionByTransCode(String transCode)
    throws BusinessException
  {
    try
    {
      Transaction transaction = new Transaction();
      transaction.setTransCode(transCode);
      transaction = this.transactionDao.selectByPrimaryKey(transCode);
      return transaction;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX03", null, e));
    }
  }

  public List<Transaction> getTransByModuleCode(String moduleCode)
    throws BusinessException
  {
    try
    {
      List transList = new ArrayList();
      transList = this.transactionDao.selectTransByModuleCode(moduleCode);
      return transList;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX02", null, e));
    }
  }

  public boolean checkTransCode(String transCode)
    throws BusinessException
  {
    try
    {
      return (this.transactionDao.findCountByTransCode(transCode) <= 0);
    }
    catch (Exception e)
    {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCK01", null, e));
    }
  }

  public boolean checkTransName(String transName)
    throws BusinessException
  {
    try
    {
      return (this.transactionDao.findCountByTransName(transName) <= 0);
    }
    catch (Exception e)
    {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCK02", null, e));
    }
  }

  public Page<Transaction> getTransByPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    try
    {
      Page page = new Page();
      page.setPageNo(pageNo);
      page.setPageSize(pageSize);
      List result = this.transactionDao.getTransByPage(params, page);
      page.setResult(result);
      return page;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX05", null, e));
    }
  }

  public Page<Transaction> getTransByModuleCodePage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    try
    {
      Page page = new Page();
      page.setPageNo(pageNo);
      page.setPageSize(pageSize);
      params.put("pageObject", page);
      List result = this.transactionDao.getTransByModuleCodePage(params);
      page.setResult(result);
      return page;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX06", null, e));
    }
  }

  public Page<Transaction> getTransByModuleCodeAndPage(Map<String, Object> params, Integer pageNo, Integer pageSize)
  {
    try
    {
      Page page = new Page();
      page.setPageNo(pageNo.intValue());
      page.setPageSize(pageSize.intValue());
      params.put("pageObject", page);
      page.setResult(this.transactionDao.selectByModulesAndPage(params));
      return page;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX07", null, e));
    }
  }
}