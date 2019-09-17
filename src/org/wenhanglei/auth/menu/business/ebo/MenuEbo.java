package org.wenhanglei.auth.menu.business.ebo;

import org.wenhanglei.auth.menu.business.ebi.MenuEbi;
import org.wenhanglei.auth.menu.dao.dao.MenuDao;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:57
 * @info:
 */
public class MenuEbo implements MenuEbi {

  private MenuDao menuDao;
  public void setMenuDao(MenuDao menuDao) {
    this.menuDao = menuDao;
  }
}
