package org.wenhanglei.auth.dept.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.wenhanglei.auth.dept.business.ebi.DeptEbi;
import org.wenhanglei.auth.dept.vo.DeptModel;
import org.wenhanglei.auth.dept.vo.DeptQueryModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:17
 * @info:
 */
public class DeptAction extends ActionSupport {

  public DeptModel dm = new DeptModel();

  public DeptQueryModel dqm = new DeptQueryModel();

  public Integer currentPage = 1;

  public Integer pageSize = 2;

  public Integer totalNum;

  public Integer maxPage;

  private DeptEbi deptEbi;
  public void setDeptEbi(DeptEbi deptEbi) {
    this.deptEbi = deptEbi;
  }

  /**
   * 新增部门或修改部门
   * @return
   */
  public String save(){
    if(dm.getUuid() == null) {
      //如果没有传递部门id则新增部门
      deptEbi.save(dm);
    }else{
      //如果传递了部门id则修改部门
      deptEbi.update(dm);
    }
    return "toList";
  }

  public String list(){
    //获取带条件查询的总页数
    totalNum = deptEbi.getCount(dqm);
    maxPage = (totalNum+pageSize-1)/pageSize;

    //带条件查询分页数据
    List<DeptModel> dmList = deptEbi.findAll(dqm, currentPage, pageSize);
    ActionContext.getContext().put("dmList", dmList);
    return "list";
  }

  public String insert(){
    if(dm.getUuid() != null){
      dm = deptEbi.findById(dm.getUuid());
    }
    return "insert";
  }

  public String delete(){
    deptEbi.delete(dm);
    return "toList";
  }

}
