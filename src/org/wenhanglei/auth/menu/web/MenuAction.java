package org.wenhanglei.auth.menu.web;

import com.opensymphony.xwork2.ActionSupport;
import org.wenhanglei.auth.menu.business.ebi.MenuEbi;
import org.wenhanglei.auth.menu.vo.MenuModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:57
 * @info:
 */
public class MenuAction extends ActionSupport {

  public MenuModel mm = new MenuModel();

  private MenuEbi menuEbi;
  public void setMenuEbi(MenuEbi menuEbi) {
    this.menuEbi = menuEbi;
  }

  /***
   * 查看所有菜单列表
   * @return
   */
  public String list(){
    return "list";
  }
}
