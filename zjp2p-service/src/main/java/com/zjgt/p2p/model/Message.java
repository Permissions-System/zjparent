package com.zjgt.p2p.model;

import java.util.Date;

public class Message
{
  private Long id;
  private Integer status;
  private Integer type;
  private String title;
  private Long memberid;
  private Date createdate;
  private String content;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = ((title == null) ? null : title.trim());
  }

  public Long getMemberid() {
    return this.memberid;
  }

  public void setMemberid(Long memberid) {
    this.memberid = memberid;
  }

  public Date getCreatedate() {
    return this.createdate;
  }

  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = ((content == null) ? null : content.trim());
  }
}