package org.wenhanglei.auth.dept.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;
import org.wenhanglei.auth.dept.vo.DeptModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:16
 * @info:
 */
@Transactional
public class DeptEbo implements DeptEbi {

  private DeptDao deptDao;
  public void setDeptDao(DeptDao deptDao) {
    this.deptDao = deptDao;
  }


  /**
   * 新增部门
   */
  @Override
  public void save(DeptModel dm) {
    deptDao.save(dm);
  }

  /**
   * 查询所有部门
   */
  @Override
  public List<DeptModel> findAll() {
    return deptDao.findAll();
  }
}
