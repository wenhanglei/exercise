package org.wenhanglei.auth.emp.dao.dao;

import org.wenhanglei.auth.emp.vo.EmpModel;

public interface EmpDao {
  EmpModel findEmpByNameAndPwd(String name, String pwd);
}
