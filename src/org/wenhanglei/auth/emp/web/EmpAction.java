package org.wenhanglei.auth.emp.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.emp.business.ebi.EmpEbi;
import org.wenhanglei.auth.emp.vo.EmpModel;

public class EmpAction extends ActionSupport implements ModelDriven<EmpModel> {

  public EmpModel em = new EmpModel();

  private DeptEbi deptEbi;
  public void setDeptEbi(DeptEbi deptEbi) {
    this.deptEbi = deptEbi;
  }
  private EmpEbi empEbi;
  public void setEmpEbi(EmpEbi empEbi) {
    this.empEbi = empEbi;
  }

  /**
   * 用户登录
   * @return
   */
  public String login(){
    EmpModel emLogin = empEbi.login(em.getName(),em.getPwd());
    if(emLogin == null){
      return "login";
    }else{
      ActionContext.getContext().getSession().put(EmpModel.LOGIN_EMP_INFO, emLogin);
      return "main";
    }
  }

  /**
   * 查询员工列表
   * @return
   */
  public String list(){
    prepareDeptList();

    return "list";
  }

  /**
   * 插入员工之前的准备数据
   * @return
   */
  public String preInput(){
    prepareDeptList();

    return "input";
  }


  @Override
  public EmpModel getModel() {
    return em;
  }

  private void prepareDeptList() {
    //查询所有部门
    List<DeptModel> deptList = deptEbi.findAll();
    ActionContext.getContext().put("deptList", deptList);
  }


}
