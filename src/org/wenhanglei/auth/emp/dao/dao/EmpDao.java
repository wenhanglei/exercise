package org.wenhanglei.auth.emp.dao.dao;

import java.util.List;
import org.wenhanglei.auth.emp.vo.EmpModel;

public interface EmpDao {
  EmpModel findEmpByNameAndPwd(String name, String pwd);

  void save(EmpModel em);

  List<EmpModel> findAll();
}
