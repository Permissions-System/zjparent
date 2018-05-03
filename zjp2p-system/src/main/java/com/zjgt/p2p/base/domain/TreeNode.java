package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.util.List;

public class TreeNode<T> implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String id;//要显示的子节点的ID  
  private String text;//要显示的子节点的 Text
  private String state;
  private String iconCls;//节点的图标  
  private Boolean checked;
  private List<TreeNode<T>> children;//孩子节点的List
  private T attributes;

  public String getId()
  {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getIconCls() {
    return this.iconCls;
  }

  public void setIconCls(String iconCls) {
    this.iconCls = iconCls;
  }

  public Boolean getChecked() {
    return this.checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public List<TreeNode<T>> getChildren() {
    return this.children;
  }

  public void setChildren(List<TreeNode<T>> children) {
    this.children = children;
  }

  public T getAttributes() {
    return this.attributes;
  }

  public void setAttributes(T attributes) {
    this.attributes = attributes;
  }
}