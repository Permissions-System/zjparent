package com.zjgt.util;

import java.io.Serializable;
import java.util.List;

public class Page<T>
  implements Serializable
{
  private static final long serialVersionUID = -3198048449643774660L;
  private List<T> results;
  private int pageNow = 1;
  private int pageSize;
  private int totalCount;
  private int totalPageCount;
  private int begin;
  private int end;
  private int startPos;
  private boolean hasFirst;
  private boolean hasPre;
  private boolean hasNext;
  private boolean hasLast;

  public int getBegin()
  {
    return this.begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return this.end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public Page(int totalCount, int pageNow)
  {
    this.totalCount = totalCount;
    this.pageNow = pageNow;
  }

  public List<T> getResults() {
    return this.results;
  }

  public void setResults(List<T> results) {
    this.results = results;
  }

  public int getTotalPageCount()
  {
    this.totalPageCount = (getTotalCount() / getPageSize());
    return ((this.totalCount % this.pageSize == 0) ? this.totalPageCount : this.totalPageCount + 1);
  }

  public void setTotalPageCount(int totalPageCount)
  {
    this.totalPageCount = totalPageCount;
  }

  public int getPageNow() {
    return this.pageNow;
  }

  public void setPageNow(int pageNow) {
    this.pageNow = pageNow;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalCount() {
    return this.totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getStartPos()
  {
    return ((this.pageNow - 1) * this.pageSize);
  }

  public void setStartPos(int startPos) {
    this.startPos = startPos;
  }

  public boolean isHasFirst()
  {
    return (this.pageNow != 1);
  }

  public void setHasFirst(boolean hasFirst) {
    this.hasFirst = hasFirst;
  }

  public boolean isHasPre()
  {
    return (isHasFirst());
  }

  public void setHasPre(boolean hasPre) {
    this.hasPre = hasPre;
  }

  public boolean isHasNext()
  {
    return (isHasLast());
  }

  public void setHasNext(boolean hasNext) {
    this.hasNext = hasNext;
  }

  public boolean isHasLast()
  {
    return (this.pageNow != getTotalCount());
  }

  public void setHasLast(boolean hasLast) {
    this.hasLast = hasLast;
  }

  public void getPager(int pageNum, int totalPage)
  {
    if (pageNum - 3 < 1)
      this.begin = 1;
    else {
      this.begin = (pageNum - 3);
    }
    if (totalPage < pageNum + 3)
      this.end = totalPage;
    else
      this.end = (pageNum + 3);
  }
}