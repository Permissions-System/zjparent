package com.zjgt.p2p.base.domain;

import com.google.common.base.Objects;

public class ShiroStaff extends User
{
  private static final long serialVersionUID = -1373760764580840081L;
  private String identNo;

  public ShiroStaff(String identNo, String name, String id)
  {
    this.identNo = identNo;
    super.setId(id);
    super.setName(name);
    super.setUserSource("2");
  }

  public String getIdentNo() {
    return this.identNo;
  }

  public boolean isSupervisor(String id)
  {
    return (id == "ABC00000000");
  }

  public boolean isSupervisor()
  {
    return getId().equals("ABC00000000");
  }

  public String toString()
  {
    return this.identNo;
  }

  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.identNo });
  }

  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (super.getClass() != obj.getClass()) {
      return false;
    }
    ShiroStaff other = (ShiroStaff)obj;
    if (this.identNo == null) {
      if (other.identNo != null)
        return false;
    }
    else if (!(this.identNo.equals(other.identNo))) {
      return false;
    }
    return true;
  }
}