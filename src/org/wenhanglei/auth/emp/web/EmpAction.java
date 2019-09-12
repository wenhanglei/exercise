package org.wenhanglei.auth.emp.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.emp.business.ebi.EmpEbi;
import org.wenhanglei.auth.emp.vo.EmpModel;
import org.wenhanglei.auth.emp.vo.EmpQueryModel;

public class EmpAction extends ActionSupport {

  public EmpModel em = new EmpModel();

  public EmpQueryModel eqm = new EmpQueryModel();

  public Integer currentPage = 1;

  public Integer pageSize = 2;

  public Integer totalNum;

  public Integer maxPage;

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
    //获取登录用户的ip地址
    HttpServletRequest request = ServletActionContext.getRequest();
    String ip = getIpAddr(request);
    EmpModel emLogin = empEbi.login(em.getName(), em.getPwd(), ip);
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

//    List<EmpModel> empList = empEbi.findAll();
    totalNum = empEbi.getCount(eqm);
    maxPage = (totalNum+pageSize-1)/pageSize;

    List<EmpModel> empList = empEbi.findAll(eqm, currentPage, pageSize);
    ActionContext.getContext().put("empList", empList);

    return "list";
  }

  /**
   * 新增员工
   * @return
   */
  public String save(){
    empEbi.save(em);

    return "toList";
  }

  /**
   * 插入员工之前的准备数据
   * @return
   */
  public String preInput(){
    prepareDeptList();

    em = empEbi.findById(em.getUuid());

    return "input";
  }

  private void prepareDeptList() {
    //查询所有部门
    List<DeptModel> deptList = deptEbi.findAll();
    ActionContext.getContext().put("deptList", deptList);
  }

  private String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

}
