package org.wenhanglei.auth.emp.business.ebo;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.emp.business.ebi.EmpEbi;
import org.wenhanglei.auth.emp.dao.dao.EmpDao;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.auth.emp.vo.EmpQueryModel;
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
  public EmpModel login(String name, String pwd, String ip) {
    pwd = Md5Util.getMD5String(pwd);
    EmpModel empLogin = empDao.findEmpByNameAndPwd(name, pwd);
    if(empLogin != null){
      empLogin.setLastLoginIp(ip);
      empLogin.setLastLoginTime(new Date());
      int loginTimes = empLogin.getLoginTimes() == null?0:empLogin.getLoginTimes();
      empLogin.setLoginTimes(loginTimes+1);
    }
    return empLogin;
  }

  /**
   * 新增员工
   */
  @Override
  public void save(EmpModel em) {
    empDao.save(em);
  }

  /**
   * 查询所有员工
   */
  @Override
  public List<EmpModel> findAll() {
    return empDao.findAll();
  }

  /**
   * 带条件分页查询员工数据
   */
  @Override
  public List<EmpModel> findAll(EmpQueryModel eqm, Integer currentPage, Integer pageSize) {
    return empDao.findAll(eqm, currentPage, pageSize);
  }

  /**
   * 条件查询总的员工记录数
   */
  @Override
  public Integer getCount(EmpQueryModel eqm) {
    return empDao.getCount(eqm);
  }

  /**
   * 根据id查询员工对象
   */
  @Override
  public EmpModel findById(Integer uuid) {
    return empDao.findById(uuid);
  }
}
