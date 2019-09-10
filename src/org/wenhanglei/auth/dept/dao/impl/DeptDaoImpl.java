package org.wenhanglei.auth.dept.dao.impl;

import java.io.Serializable;
import java.util.List;
import javafx.scene.shape.HLineTo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.dept.vo.DeptQueryModel;

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

  @Override
  public DeptModel findById(Long uuid) {
    String hql = "from DeptModel as dm where dm.uuid = ?";
    List<DeptModel> list = this.getHibernateTemplate().find(hql, uuid);
    return list.size()>0?list.get(0):null;
  }

  @Override
  public void update(DeptModel dm) {
    this.getHibernateTemplate().update(dm);
  }

  @Override
  public List<DeptModel> findAll(DeptQueryModel dqm) {
    DetachedCriteria criteria = DetachedCriteria.forClass(DeptModel.class);

    if(dqm.getName() != null && !StringUtils.isEmpty(dqm.getName())){
      criteria.add(Restrictions.like("name", "%" + dqm.getName().trim() + "%"));
    }

    if(dqm.getTelephone() != null && !StringUtils.isEmpty(dqm.getTelephone())){
      criteria.add(Restrictions.like("telephone", "%" + dqm.getTelephone().trim() + "%"));
    }

    return this.getHibernateTemplate().findByCriteria(criteria);
  }
}
