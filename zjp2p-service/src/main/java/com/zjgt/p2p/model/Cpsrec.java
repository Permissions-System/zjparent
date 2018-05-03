package com.zjgt.p2p.model;

import java.util.Date;

public class Cpsrec
{
  private Long id;
  private String pagename;
  private String url;
  private String channel;
  private String channel2;
  private String sessionid;
  private Long memberid;
  private String userdistrict;
  private String operation;
  private Date opdate;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getPagename()
  {
    return this.pagename;
  }

  public void setPagename(String pagename)
  {
    this.pagename = ((pagename == null) ? null : pagename.trim());
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url)
  {
    this.url = ((url == null) ? null : url.trim());
  }

  public String getChannel()
  {
    return this.channel;
  }

  public void setChannel(String channel)
  {
    this.channel = ((channel == null) ? null : channel.trim());
  }

  public String getChannel2()
  {
    return this.channel2;
  }

  public void setChannel2(String channel2)
  {
    this.channel2 = ((channel2 == null) ? null : channel2.trim());
  }

  public String getSessionid()
  {
    return this.sessionid;
  }

  public void setSessionid(String sessionid)
  {
    this.sessionid = ((sessionid == null) ? null : sessionid.trim());
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public String getUserdistrict()
  {
    return this.userdistrict;
  }

  public void setUserdistrict(String userdistrict)
  {
    this.userdistrict = ((userdistrict == null) ? null : userdistrict.trim());
  }

  public String getOperation()
  {
    return this.operation;
  }

  public void setOperation(String operation)
  {
    this.operation = ((operation == null) ? null : operation.trim());
  }

  public Date getOpdate()
  {
    return this.opdate;
  }

  public void setOpdate(Date opdate)
  {
    this.opdate = opdate;
  }
}