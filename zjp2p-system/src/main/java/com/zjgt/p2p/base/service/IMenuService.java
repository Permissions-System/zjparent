package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Menu;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IMenuService
{
  public abstract Menu getMenuInfo(String paramString)
    throws BusinessException;

  public abstract List<Menu> getRootMenuList()
    throws BusinessException;

  public abstract List<Menu> getSubMenuList(String paramString)
    throws BusinessException;

  public abstract Menu saveMenuNode(Menu paramMenu)
    throws BusinessException;

  public abstract Menu updateMenuNode(Menu paramMenu)
    throws BusinessException;

  public abstract void deleteMenuNode(String paramString)
    throws BusinessException;

  public abstract List<Menu> findAllMenuInfoList()
    throws BusinessException;

  public abstract List<Menu> getMenuTreeList()
    throws BusinessException;

  public abstract List<Menu> getMenuTreeListThroughTreepath()
    throws BusinessException;

  public abstract Menu getStaffMenus(String paramString)
    throws BusinessException;

  public abstract Menu getAdminMenus()
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IMenuService
 * JD-Core Version:    0.5.3
 */