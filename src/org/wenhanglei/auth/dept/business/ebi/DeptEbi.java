package org.wenhanglei.auth.dept.business.ebi;

import java.util.List;
import org.wenhanglei.auth.dept.vo.DeptModel;

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
}
