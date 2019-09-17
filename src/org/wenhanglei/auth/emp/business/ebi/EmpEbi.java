package org.wenhanglei.auth.emp.business.ebi;

import java.util.List;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.auth.emp.vo.EmpQueryModel;

public interface EmpEbi {

  /**
   * 用户登录并返回登录用户的详细信息
   * @param name
   * @param pwd
   * @param ip
   * @return
   */
  EmpModel login(String name, String pwd, String ip);

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

  /**
   * 带条件分页查询员工数据
   * @param eqm
   * @param currentPage
   * @param pageSize
   * @return
   */
  List<EmpModel> findAll(EmpQueryModel eqm, Integer currentPage, Integer pageSize);

  /**
   * 条件查询总的员工记录数
   * @param eqm
   * @return
   */
  Integer getCount(EmpQueryModel eqm);

  /**
   * 根据id查询员工对象
   * @param uuid
   * @return
   */
  EmpModel findById(Integer uuid);

  /**
   * 修改员工数据
   * @param em
   */
  void update(EmpModel em);

  /**
   * 删除员工
   * @param em
   */
  void delete(EmpModel em);

  /**
   * 修改密码
   * @param oldPwd
   * @param newPwd
   */
  void changePwd(String oldPwd, String newPwd);
}
