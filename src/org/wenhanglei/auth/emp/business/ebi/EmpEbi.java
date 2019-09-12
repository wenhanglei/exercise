package org.wenhanglei.auth.emp.business.ebi;

import java.util.List;
import org.wenhanglei.auth.emp.vo.EmpModel;

public interface EmpEbi {

  /**
   * 用户登录并返回登录用户的详细信息
   * @param name
   * @param pwd
   * @return
   */
  EmpModel login(String name, String pwd);

  /**
   * 新增员工
   * @param em
   */
  void save(EmpModel em);

  /**
   * 查询所有员工
   * @return
   */
  List<EmpModel> findAll();
}
