package org.wenhanglei.auth.emp.vo;

import java.util.Date;
import org.wenhanglei.auth.dept.vo.DeptModel;

public class EmpModel {

  public final static String LOGIN_EMP_INFO = "login_emp";

  /**
   * 标识
   */
  private Integer uuid;

  /**
   * 用户名
   */
  private String name;

  /**
   * 真实姓名
   */
  private String realName;

  /**
   * 电话
   */
  private String telephone;

  /**
   * 性别
   */
  private String sex;

  /**
   * 生日
   */
  private Date birthday;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 地址
   */
  private String address;

  /**
   * 上次登录时间
   */
  private Date lastLoginTime;

  /**
   * 登录ip
   */
  private String lastLoginIp;

  /**
   * 登录次数
   */
  private Integer loginTimes;

  /**
   * 用户密码
   */
  private String pwd;

  /**
   * 员工所属部门
   */
  private DeptModel dept = new DeptModel();

  public Integer getUuid() {
    return uuid;
  }

  public void setUuid(Integer uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }

  public Integer getLoginTimes() {
    return loginTimes;
  }

  public void setLoginTimes(Integer loginTimes) {
    this.loginTimes = loginTimes;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public DeptModel getDept() {
    return dept;
  }

  public void setDept(DeptModel dept) {
    this.dept = dept;
  }
}
