package org.wenhanglei.auth.emp.business.ebo;

import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.wenhanglei.auth.dept.dao.dao.DeptDao;
import org.wenhanglei.auth.dept.vo.DeptModel;
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

  private DeptDao deptDao;
  public void setDeptDao(DeptDao deptDao) {
    this.deptDao = deptDao;
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
    //对员工密码加密
    em.setPwd(Md5Util.getMD5String(em.getPwd()));
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

  /**
   * 修改员工数据
   */
  @Override
  public void update(EmpModel em) {
    EmpModel oldEmp = empDao.findById(em.getUuid());
    if(oldEmp == null){
      throw new RuntimeException("当前修改的用户不存在，操作失败");
    }
    DeptModel dept = deptDao.findById(em.getDept().getUuid());
    if(dept == null){
      throw new RuntimeException("您所选择的部门不存在，操作失败");
    }

    if(em.getPwd() != null && !StringUtils.isEmpty(em.getPwd().trim())){
      String newPwd = Md5Util.getMD5String(em.getPwd().trim());
      oldEmp.setPwd(newPwd);
    }
    oldEmp.setAddress(em.getAddress().trim());
    oldEmp.setBirthday(em.getBirthday());
    oldEmp.setDept(dept);
    oldEmp.setEmail(em.getEmail().trim());
    oldEmp.setName(em.getName().trim());
    oldEmp.setRealName(em.getRealName().trim());
    oldEmp.setSex(em.getSex());
    oldEmp.setTelephone(em.getTelephone().trim());

    empDao.save(oldEmp);
  }

  /**
   * 删除员工
   */
  @Override
  public void delete(EmpModel em) {
    //将员工的关联的部门置空
    em.setDept(null);
    empDao.delete(em);
  }

  /**
   * 修改密码
   */
  @Override
  public void changePwd(String oldPwd, String newPwd) {
    EmpModel loginEmp = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.LOGIN_EMP_INFO);
    EmpModel perEmp = empDao.findById(loginEmp.getUuid());
    oldPwd = Md5Util.getMD5String(oldPwd);
    if(!perEmp.getPwd().equals(oldPwd)){
      throw new RuntimeException("您输入的密码错误");
    }
    perEmp.setPwd(Md5Util.getMD5String(newPwd));
    empDao.save(perEmp);
  }
}
