package org.wenhanglei.auth.dept.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.vo.DeptModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:17
 * @info:
 */
public class DeptAction extends ActionSupport {

  public DeptModel dm = new DeptModel();

  private DeptEbi deptEbi;
  public void setDeptEbi(DeptEbi deptEbi) {
    this.deptEbi = deptEbi;
  }

  /**
   * 新增部门
   * @return
   */
  public String save(){
    deptEbi.save(dm);
    return "list";
  }

  public String list(){
    List<DeptModel> dmList = deptEbi.findAll();
    ActionContext.getContext().put("dmList", dmList);
    return "list";
  }

  public String insert(){
    return "insert";
  }
}
