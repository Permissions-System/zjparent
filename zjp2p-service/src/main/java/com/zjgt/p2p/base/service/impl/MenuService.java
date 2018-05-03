package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.MenuDao;
import com.zjgt.p2p.base.domain.Menu;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IMenuService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MenuService
  implements IMenuService
{

  @Autowired
  private MenuDao menuDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  private void validateMenu(Menu menu)
  {
    try
    {
      Set result = this.validator.validate(menu, new Class[0]);
      if (!(result.isEmpty()))
      {
        BusinessException ex = new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU01", null, null));

        ex.setErrorMessages(result);
        throw ex;
      }
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public Menu getMenuInfo(String menuCode)
    throws BusinessException
  {
    try
    {
      return this.menuDao.selectByPrimaryKey(menuCode);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Menu> getRootMenuList()
    throws BusinessException
  {
    try
    {
      return this.menuDao.getRootMenuList();
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Menu> getSubMenuList(String menuCode)
    throws BusinessException
  {
    try
    {
      if ((null == menuCode) || (menuCode.trim().isEmpty())) {
        return null;
      }
      return this.menuDao.getSubMenuList(menuCode);
    }
    catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public Menu saveMenuNode(Menu menu)
    throws BusinessException
  {
    try
    {
      Menu existMenu = this.menuDao.selectByPrimaryKey(menu.getMenuCode());
      if (existMenu != null) {
        List list = new ArrayList();
        list.add(existMenu.getMenuCode());
        throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU02", null, list, null));
      }

      if (!("ROOT".equals(menu.getParentMenuCode()))) {
        Menu parentMenu = this.menuDao.selectByPrimaryKey(menu.getParentMenuCode());
        menu.setTreepath(parentMenu.getTreepath() + parentMenu.getMenuCode() + "/");
      } else {
        menu.setTreepath("/");
      }
      validateMenu(menu);
      this.menuDao.insert(menu);
      return menu;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU06", null, e));
    }
  }

  public Menu updateMenuNode(Menu menu)
    throws BusinessException
  {
    try
    {
      Menu oldInfo = this.menuDao.selectByPrimaryKey(menu.getMenuCode());
      if (!("ROOT".equals(menu.getParentMenuCode()))) {
        Menu parentMenu = this.menuDao.selectByPrimaryKey(menu.getParentMenuCode());
        menu.setTreepath(parentMenu.getTreepath() + parentMenu.getMenuCode() + "/");
      } else {
        menu.setTreepath("/");
      }
      if (oldInfo == null) {
        throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU03", null, new Exception()));
      }

      String newParentMenuCode = menu.getParentMenuCode();
      if (menu.getMenuCode().equals(newParentMenuCode))
        throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU04", null, new Exception()));
      Iterator i$;
      Menu subMenu;
      if (!(oldInfo.getParentMenuCode().equals(menu.getParentMenuCode())))
      {
        List subMenus = this.menuDao.getAllSubMenus(menu.getMenuCode());
        if ((subMenus != null) && (subMenus.size() > 0)) {
          Map menuMap = new HashMap();
          menuMap.put(menu.getMenuCode(), menu);
          for (i$ = subMenus.iterator(); i$.hasNext(); ) { subMenu = (Menu)i$.next();
            if (subMenu.getMenuCode().equals(newParentMenuCode)) {
              throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU05", null, new Exception()));
            }

            Menu parentMenu = (Menu)menuMap.get(subMenu.getParentMenuCode());
            String treepath = parentMenu.getTreepath() + parentMenu.getMenuCode() + "/";
            subMenu.setTreepath(treepath);
            menuMap.put(subMenu.getMenuCode(), subMenu);
          }

          for (i$ = subMenus.iterator(); i$.hasNext(); ) { subMenu = (Menu)i$.next();
            updateByPrimaryKey(subMenu);
          }
        }
      }

      updateByPrimaryKey(menu);
      return menu;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  private void updateByPrimaryKey(Menu menu)
  {
    try
    {
      validateMenu(menu);
      this.menuDao.updateByPrimaryKey(menu);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU07", null, e));
    }
  }

  public void deleteMenuNode(String menuCode)
    throws BusinessException
  {
    try
    {
      this.menuDao.deleteByPrimaryKey(menuCode);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMENU08", null, e));
    }
  }

  public List<Menu> findAllMenuInfoList()
    throws BusinessException
  {
    try
    {
      return this.menuDao.selectAll();
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Menu> getMenuTreeList()
    throws BusinessException
  {
    try
    {
    	List<Menu> menuList = this.menuDao.getRootMenuList();
      if (menuList != null) {
        for (Menu menu : menuList) {
          menu.setSubMenuList(getSubMenuTreeList(menu.getMenuCode()));
        }
      }
      return menuList;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  private List<Menu> getSubMenuTreeList(String menuCode)
  {
    try
    {
      List<Menu> menuList = this.menuDao.getSubMenuList(menuCode);
      if (menuList != null) {
        for (Menu menu : menuList) {
          menu.setSubMenuList(getSubMenuTreeList(menu.getMenuCode()));
        }
      }
      return menuList;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Menu> getMenuTreeListThroughTreepath()
    throws BusinessException
  {
    try
    {
      List<Menu> allMenus = this.menuDao.selectAll();
      if ((allMenus != null) && (allMenus.size() > 0)) {
        Menu rootMenu = new Menu();
        rootMenu.setMenuCode("ROOT");
        Map map = new HashMap();
        map.put(rootMenu.getMenuCode(), rootMenu);
        for (Menu menu : allMenus) {
          if (map.containsKey(menu.getParentMenuCode())) {
            Menu parentMenu = (Menu)map.get(menu.getParentMenuCode());
            List list = parentMenu.getSubMenuList();
            if (list == null) {
              list = new ArrayList();
              parentMenu.setSubMenuList(list);
            }
            list.add(menu);
          }
          map.put(menu.getMenuCode(), menu);
        }
        return rootMenu.getSubMenuList();
      }
      return null;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public Menu getStaffMenus(String staffNo)
    throws BusinessException
  {
    try
    {
      Map paramMap = new HashMap();
      paramMap.put("staffNo", staffNo);
      paramMap.put("startMenuCode", "");
      List menuList = this.menuDao.getMenuTreeListByStaffNo(paramMap);
      return createMenuTree(menuList);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public Menu getAdminMenus()
    throws BusinessException
  {
    try
    {
      Map paramMap = new HashMap();
      paramMap.put("startMenuCode", "");
      List menuList = this.menuDao.getMenuTreeForAdmin(paramMap);
      return createMenuTree(menuList);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  private Menu createMenuTree(List<Menu> menuList)
  {
    try
    {
      if ((menuList == null) || (menuList.size() == 0)) {
        return null;
      }
      Map map = new HashMap();
      Menu rootMenu = new Menu();
      rootMenu.setMenuCode("ROOT");
      map.put(rootMenu.getMenuCode(), rootMenu);
      for (Menu menu : menuList) {
        if (map.containsKey(menu.getMenuCode()))
        {
          String url = menu.getUrl();
          if ((url != null) && (!(url.trim().isEmpty())));
          Menu mapMenu = (Menu)map.get(menu.getMenuCode());
          mapMenu.setUrl(url);
        }

        if (map.containsKey(menu.getParentMenuCode())) {
          Menu menuParent = (Menu)map.get(menu.getParentMenuCode());
          List subMenuList = menuParent.getSubMenuList();
          if (subMenuList == null) {
            subMenuList = new ArrayList();
            menuParent.setSubMenuList(subMenuList);
          }
          subMenuList.add(menu);
        }
        map.put(menu.getMenuCode(), menu);
      }
      return ((Menu)map.get("ROOT"));
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }
}