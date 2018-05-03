package com.zjgt.p2p.exception;

public class MemberException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public MemberException()
  {
  }

  public MemberException(String msg)
  {
    super(msg);
  }
}