package org.wenhanglei.auth.dept.dao.dao;

import java.util.List;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.dept.vo.DeptQueryModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:16
 * @info:
 */
public interface DeptDao {

  void save(DeptModel dm);

  List<DeptModel> findAll();

  DeptModel findById(Long uuid);

  void update(DeptModel dm);

  List<DeptModel> findAll(DeptQueryModel dqm);

  List<DeptModel> findAll(DeptQueryModel dqm, Integer currentPage, Integer pageSize);

  void delete(DeptModel dm);
}
