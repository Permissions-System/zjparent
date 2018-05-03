package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WebTrans
  implements Serializable
{
  private static final long serialVersionUID = 3476796240859620220L;

  @NotNull(message="交易代码不能为空")
  @Size(min=1, max=10, message="交易代码长度应不超过10个字符")
  private String transCode;

  @NotNull(message="交易名称不能为空")
  @Size(min=1, max=20, message="交易名称长度应不超过20个字符")
  private String transName;

  @NotNull(message="产品代码不能为空")
  private String productCode;

  @NotNull(message="模块名称不能为空")
  @Size(min=1, max=20, message="模块名称长度应不超过20个字符")
  private String moduleName;
  private BigDecimal recheckLevel;

  @Size(max=150, message="复核详细信息页面URL应不超过150个字符")
  private String recheckDetailPage;

  @Size(max=150, message="复核终核处理页面URL应不超过150个字符")
  private String recheckHandlePage;

  public String getTransCode()
  {
    return this.transCode;
  }

  public void setTransCode(String transCode)
  {
    this.transCode = ((transCode == null) ? null : transCode.trim());
  }

  public String getTransName()
  {
    return this.transName;
  }

  public void setTransName(String transName)
  {
    this.transName = ((transName == null) ? null : transName.trim());
  }

  public String getProductCode()
  {
    return this.productCode;
  }

  public void setProductCode(String productCode)
  {
    this.productCode = ((productCode == null) ? null : productCode.trim());
  }

  public String getModuleName()
  {
    return this.moduleName;
  }

  public void setModuleName(String moduleName)
  {
    this.moduleName = ((moduleName == null) ? null : moduleName.trim());
  }

  public BigDecimal getRecheckLevel()
  {
    return this.recheckLevel;
  }

  public void setRecheckLevel(BigDecimal recheckLevel)
  {
    this.recheckLevel = recheckLevel;
  }

  public String getRecheckDetailPage()
  {
    return this.recheckDetailPage;
  }

  public void setRecheckDetailPage(String recheckDetailPage)
  {
    this.recheckDetailPage = ((recheckDetailPage == null) ? null : recheckDetailPage.trim());
  }

  public String getRecheckHandlePage()
  {
    return this.recheckHandlePage;
  }

  public void setRecheckHandlePage(String recheckHandlePage)
  {
    this.recheckHandlePage = ((recheckHandlePage == null) ? null : recheckHandlePage.trim());
  }
}