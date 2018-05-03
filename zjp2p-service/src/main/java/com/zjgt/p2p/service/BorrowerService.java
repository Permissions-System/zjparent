package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Borrower;
import com.zjgt.util.Page;
import java.util.List;
import java.util.Map;

public abstract interface BorrowerService
{
  public abstract Borrower findById(String paramString);

  public abstract List<Borrower> selectAll();

  public abstract Page<Borrower> selectBorrowerByPage(Map<String, String> paramMap);

  public abstract int addBorrower(Borrower paramBorrower);

  public abstract int updateBorrower(Borrower paramBorrower);

  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract Borrower findBybid(String paramString);
}