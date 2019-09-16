package org.wenhanglei.auth.emp.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wenhanglei.auth.emp.dao.dao.EmpDao;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.auth.emp.vo.EmpQueryModel;
import org.wenhanglei.utils.Md5Util;

public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {

  @Override
  public EmpModel findEmpByNameAndPwd(String name, String pwd) {
    String hql = "from EmpModel em where em.name = ? and em.pwd = ?";
    List<EmpModel> list = this.getHibernateTemplate().find(hql, name, pwd);
    if(list != null && list.size() > 0){
      return list.get(0);
    }
    return null;
  }

  @Override
  public void save(EmpModel em) {
    //对员工密码进行加密
    em.setPwd(Md5Util.getMD5String(em.getPwd()));
    this.getHibernateTemplate().save(em);
  }

  @Override
  public List<EmpModel> findAll() {
    String hql = "from EmpModel";
    return this.getHibernateTemplate().find(hql);
  }

  @Override
  public List<EmpModel> findAll(EmpQueryModel eqm, Integer currentPage, Integer pageSize) {
    DetachedCriteria criteria = DetachedCriteria.forClass(EmpModel.class);

    return this.getHibernateTemplate().findByCriteria(criteria, (currentPage-1)*pageSize, pageSize);
  }

  @Override
  public Integer getCount(EmpQueryModel eqm) {
    DetachedCriteria criteria = DetachedCriteria.forClass(EmpModel.class);

    criteria.setProjection(Projections.rowCount());

    List<Long> list = this.getHibernateTemplate().findByCriteria(criteria);

    return list.get(0).intValue();
  }

  @Override
  public EmpModel findById(Integer uuid) {
    String hql = "from EmpModel em where em.uuid = ?";
    List<EmpModel> list = this.getHibernateTemplate().find(hql, uuid);
    return list.size()>0?list.get(0):null;
  }

  @Override
  public void delete(EmpModel em) {
    this.getHibernateTemplate().delete(em);
  }
}
