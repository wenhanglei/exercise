package org.wenhanglei.emp.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wenhanglei.emp.dao.dao.EmpDao;
import org.wenhanglei.emp.vo.EmpModel;

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
}
