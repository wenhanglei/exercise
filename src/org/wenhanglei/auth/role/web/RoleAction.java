package org.wenhanglei.auth.role.web;

import com.opensymphony.xwork2.ActionSupport;
import org.wenhanglei.auth.role.business.ebi.RoleEbi;
import org.wenhanglei.auth.role.vo.RoleModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:26
 * @info:
 */
public class RoleAction extends ActionSupport {

  public RoleModel rm = new RoleModel();

  private RoleEbi roleEbi;
  public void setRoleEbi(RoleEbi roleEbi) {
    this.roleEbi = roleEbi;
  }

  /**
   * 查询所有角色
   * @return
   */
  public String list(){
    return "list";
  }

}
