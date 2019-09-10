package org.wenhanglei.auth.dept.business.ebi;

import java.util.List;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.dept.vo.DeptQueryModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:16
 * @info:
 */
public interface DeptEbi {

  /**
   * 新增部门
   * @param dm
   */
  void save(DeptModel dm);

  /**
   * 查询所有部门
   * @return
   */
  List<DeptModel> findAll();

  /**
   * 根据id查询部门信息
   * @param uuid
   * @return
   */
  DeptModel findById(Long uuid);

  /**
   * 修改部门
   * @param dm
   */
  void update(DeptModel dm);

  /**
   * 条件查询部门列表
   * @param dqm
   * @return
   */
  List<DeptModel> findAll(DeptQueryModel dqm);
}
