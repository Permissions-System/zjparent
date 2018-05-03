package com.zjgt.shiro.token;

import com.zjgt.p2p.model.Member;
import org.apache.shiro.authc.AuthenticationToken;

public class NoPasswordToken
  implements AuthenticationToken
{
  private static final long serialVersionUID = 1L;
  private String key;
  private Member member;

  public Object getPrincipal()
  {
    return null;
  }

  public Object getCredentials()
  {
    return this.key;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Member getMember() {
    return this.member;
  }

  public void setMember(Member member) {
    this.member = member;
  }
}