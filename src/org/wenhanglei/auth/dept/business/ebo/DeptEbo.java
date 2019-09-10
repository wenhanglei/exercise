package org.wenhanglei.auth.dept.business.ebo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.dept.vo.DeptQueryModel;

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

  /**
   * 根据id查询部门信息
   */
  @Override
  public DeptModel findById(Long uuid) {
    return deptDao.findById(uuid);
  }

  /**
   * 修改部门
   */
  @Override
  public void update(DeptModel dm) {
    deptDao.update(dm);
  }

  /**
   * 条件查询部门列表
   */
  @Override
  public List<DeptModel> findAll(DeptQueryModel dqm) {
    return deptDao.findAll(dqm);
  }

  /**
   * 分页查询部门列表
   */
  @Override
  public List<DeptModel> findAll(DeptQueryModel dqm, Integer currentPage, Integer pageSize) {
    return deptDao.findAll(dqm, currentPage, pageSize);
  }

  /**
   * 删除部门
   */
  @Override
  public void delete(DeptModel dm) {
    deptDao.delete(dm);
  }
}
