package org.wenhanglei.emp.dao.dao;

import org.wenhanglei.emp.vo.EmpModel;

public interface EmpDao {
  EmpModel findEmpByNameAndPwd(String name, String pwd);
}
