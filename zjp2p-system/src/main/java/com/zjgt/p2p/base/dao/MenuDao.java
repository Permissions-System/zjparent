package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Menu;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface MenuDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Menu paramMenu);

  public abstract Menu selectByPrimaryKey(String paramString);

  public abstract List<Menu> selectAll();

  public abstract int updateByPrimaryKey(Menu paramMenu);

  public abstract List<Menu> getRootMenuList();

  public abstract List<Menu> getSubMenuList(String paramString);

  public abstract List<Menu> getAllSubMenus(String paramString);

  public abstract List<Menu> getMenuTreeListByStaffNo(Map<String, String> paramMap);

  public abstract List<Menu> getMenuTreeForAdmin(Map<String, String> paramMap);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.MenuDao
 * JD-Core Version:    0.5.3
 */