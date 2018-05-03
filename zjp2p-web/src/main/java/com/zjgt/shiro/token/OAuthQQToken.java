package com.zjgt.shiro.token;

import com.zjgt.p2p.model.Member;
import org.apache.shiro.authc.AuthenticationToken;

public class OAuthQQToken
  implements AuthenticationToken
{
  private static final long serialVersionUID = 1L;
  private String authCode;
  private String openId;
  private Member member;

  public Object getPrincipal()
  {
    return null;
  }

  public Object getCredentials()
  {
    return this.openId;
  }

  public String getAuthCode() {
    return this.authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public Member getMember() {
    return this.member;
  }

  public void setMember(Member member) {
    this.member = member;
  }
}