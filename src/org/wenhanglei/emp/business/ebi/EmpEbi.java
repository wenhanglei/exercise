package org.wenhanglei.emp.business.ebi;

import org.wenhanglei.emp.vo.EmpModel;

public interface EmpEbi {

  /**
   * 用户登录并返回登录用户的详细信息
   * @param name
   * @param pwd
   * @return
   */
  EmpModel login(String name, String pwd);
}
