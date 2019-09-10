package org.wenhanglei.auth.emp.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.wenhanglei.auth.emp.business.ebi.EmpEbi;
import org.wenhanglei.auth.emp.vo.EmpModel;

public class EmpAction extends ActionSupport implements ModelDriven<EmpModel> {

  public EmpModel em = new EmpModel();

  private EmpEbi empEbi;
  public void setEmpEbi(EmpEbi empEbi) {
    this.empEbi = empEbi;
  }

  public String login(){
    EmpModel emLogin = empEbi.login(em.getName(),em.getPwd());
    if(emLogin == null){
      return "login";
    }else{
      ActionContext.getContext().getSession().put(EmpModel.LOGIN_EMP_INFO, emLogin);
      return "main";
    }
  }

  @Override
  public EmpModel getModel() {
    return em;
  }
}
