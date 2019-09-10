package org.wenhanglei.auth.dept.business.ebo;

import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;

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


}
