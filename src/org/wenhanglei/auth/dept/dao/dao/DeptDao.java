package org.wenhanglei.auth.dept.dao.dao;

import java.util.List;
import org.wenhanglei.auth.dept.vo.DeptModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:16
 * @info:
 */
public interface DeptDao {

  void save(DeptModel dm);

  List<DeptModel> findAll();
}
