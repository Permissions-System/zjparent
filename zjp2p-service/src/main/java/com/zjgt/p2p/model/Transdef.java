package com.zjgt.p2p.model;

public class Transdef
{
  private String trancode;
  private String trantype;
  private String tranname;
  private String transtatus;
  private String trandesc;
  private Byte isnotify;
  private String notifymethod;

  public String getTrancode()
  {
    return this.trancode;
  }

  public void setTrancode(String trancode)
  {
    this.trancode = ((trancode == null) ? null : trancode.trim());
  }

  public String getTrantype()
  {
    return this.trantype;
  }

  public void setTrantype(String trantype)
  {
    this.trantype = ((trantype == null) ? null : trantype.trim());
  }

  public String getTranname()
  {
    return this.tranname;
  }

  public void setTranname(String tranname)
  {
    this.tranname = ((tranname == null) ? null : tranname.trim());
  }

  public String getTranstatus()
  {
    return this.transtatus;
  }

  public void setTranstatus(String transtatus)
  {
    this.transtatus = ((transtatus == null) ? null : transtatus.trim());
  }

  public String getTrandesc()
  {
    return this.trandesc;
  }

  public void setTrandesc(String trandesc)
  {
    this.trandesc = ((trandesc == null) ? null : trandesc.trim());
  }

  public Byte getIsnotify()
  {
    return this.isnotify;
  }

  public void setIsnotify(Byte isnotify)
  {
    this.isnotify = isnotify;
  }

  public String getNotifymethod()
  {
    return this.notifymethod;
  }

  public void setNotifymethod(String notifymethod)
  {
    this.notifymethod = ((notifymethod == null) ? null : notifymethod.trim());
  }
}