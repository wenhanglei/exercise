package org.wenhanglei.auth.emp.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wenhanglei.auth.emp.dao.dao.EmpDao;
import org.wenhanglei.auth.emp.vo.EmpModel;

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
    this.getHibernateTemplate().save(em);
  }

  @Override
  public List<EmpModel> findAll() {
    String hql = "from EmpModel";
    return this.getHibernateTemplate().find(hql);
  }
}
