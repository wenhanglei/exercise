package org.wenhanglei.auth.role.business.ebo;

import org.wenhanglei.auth.role.business.ebi.RoleEbi;
import org.wenhanglei.auth.role.dao.dao.RoleDao;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:28
 * @info:
 */
public class RoleEbo implements RoleEbi {

  private RoleDao roleDao;
  public void setRoleDao(RoleDao roleDao) {
    this.roleDao = roleDao;
  }
}
