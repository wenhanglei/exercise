package org.wenhanglei.auth.dept.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;
import org.wenhanglei.auth.dept.vo.DeptModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:16
 * @info:
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

  @Override
  public void save(DeptModel dm) {
    this.getHibernateTemplate().save(dm);
  }

  @Override
  public List<DeptModel> findAll() {
    String hql = "from DeptModel";
    List<DeptModel> result = this.getHibernateTemplate().find(hql);
    return result;
  }
}
