package org.wenhanglei.auth.emp.business.ebo;

import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.emp.business.ebi.EmpEbi;
import org.wenhanglei.auth.emp.dao.dao.EmpDao;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.utils.Md5Util;

@Transactional
public class EmpEbo implements EmpEbi {

  private EmpDao empDao;
  public void setEmpDao(EmpDao empDao) {
    this.empDao = empDao;
  }

  /**
   * 用户登录并返回登录用户的详细信息
   */
  @Override
  public EmpModel login(String name, String pwd) {
    pwd = Md5Util.getMD5String(pwd);
    EmpModel empLogin = empDao.findEmpByNameAndPwd(name, pwd);
    return empLogin;
  }
}
