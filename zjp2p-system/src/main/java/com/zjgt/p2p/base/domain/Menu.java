package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Menu
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="菜单编号不能为空")
  @Size(min=1, max=10, message="菜单编号长度在1到10之间")
  private String menuCode;

  @NotNull(message="菜单名称不能为空")
  @Size(min=1, max=60, message="菜单编号长度在1到60之间")
  private String menuName;

  @Size(max=10, message="交易码长度不能大于10")
  private String transCode;

  @NotNull(message="treepath不能为空")
  @Size(min=1, max=50, message="超过系统菜单层级深度限制")
  private String treepath;
  private BigDecimal orderNum;

  @NotNull(message="菜单状态不能为空")
  @Size(min=1, max=1, message="菜单状态长度为1")
  private String menuStatus;

  @NotNull(message="上级菜单编码不能为空")
  @Size(min=1, max=10, message="上级菜单编码长度在1到10之间")
  private String parentMenuCode;
  private String url;
  private List<Menu> subMenuList;

  public String getMenuCode()
  {
    return this.menuCode;
  }

  public void setMenuCode(String menuCode) {
    this.menuCode = ((menuCode == null) ? null : menuCode.trim());
  }

  public String getMenuName() {
    return this.menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = ((menuName == null) ? null : menuName.trim());
  }

  public String getTransCode() {
    return this.transCode;
  }

  public void setTransCode(String transCode) {
    this.transCode = ((transCode == null) ? null : transCode.trim());
  }

  public String getTreepath() {
    return this.treepath;
  }

  public void setTreepath(String treepath) {
    this.treepath = ((treepath == null) ? null : treepath.trim());
  }

  public BigDecimal getOrderNum() {
    return this.orderNum;
  }

  public void setOrderNum(BigDecimal orderNum) {
    this.orderNum = orderNum;
  }

  public String getMenuStatus() {
    return this.menuStatus;
  }

  public void setMenuStatus(String menuStatus) {
    this.menuStatus = ((menuStatus == null) ? null : menuStatus.trim());
  }

  public String getParentMenuCode() {
    return this.parentMenuCode;
  }

  public void setParentMenuCode(String parentMenuCode) {
    this.parentMenuCode = ((parentMenuCode == null) ? null : parentMenuCode.trim());
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Menu> getSubMenuList() {
    return this.subMenuList;
  }

  public void setSubMenuList(List<Menu> subMenuList) {
    this.subMenuList = subMenuList;
  }
}