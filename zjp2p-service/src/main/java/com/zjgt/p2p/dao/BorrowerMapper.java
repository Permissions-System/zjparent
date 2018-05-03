package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Borrower;
import com.zjgt.p2p.model.BorrowerExample;
import java.util.List;

public abstract interface BorrowerMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(Borrower paramBorrower);

  public abstract int insertSelective(Borrower paramBorrower);

  public abstract List<Borrower> selectByExample(BorrowerExample paramBorrowerExample);

  public abstract Borrower selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(Borrower paramBorrower);

  public abstract int updateByPrimaryKey(Borrower paramBorrower);

  public abstract List<Borrower> selectByExampleLimit(BorrowerExample paramBorrowerExample);

  public abstract int getBorrowerCount(BorrowerExample paramBorrowerExample);
}