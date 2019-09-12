package org.wenhanglei.auth.emp.dao.dao;

import java.util.List;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.auth.emp.vo.EmpQueryModel;

public interface EmpDao {
  EmpModel findEmpByNameAndPwd(String name, String pwd);

  void save(EmpModel em);

  List<EmpModel> findAll();

  List<EmpModel> findAll(EmpQueryModel eqm, Integer currentPage, Integer pageSize);

  Integer getCount(EmpQueryModel eqm);

  EmpModel findById(Integer uuid);
}
