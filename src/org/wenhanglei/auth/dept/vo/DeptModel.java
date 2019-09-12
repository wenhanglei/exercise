package org.wenhanglei.auth.dept.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.wenhanglei.auth.emp.vo.EmpModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 11:11
 * @info:
 */
public class DeptModel {

  /**
   * 标识
   */
  private Long uuid;

  /**
   * 部门名称
   */
  private String name;

  /**
   * 部门联系电话
   */
  private String telephone;

  /**
   * 员工列表
   */
  private Set<EmpModel> empList = new HashSet<EmpModel>();

  public Long getUuid() {
    return uuid;
  }

  public void setUuid(Long uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Set<EmpModel> getEmpList() {
    return empList;
  }

  public void setEmpList(Set<EmpModel> empList) {
    this.empList = empList;
  }

}
