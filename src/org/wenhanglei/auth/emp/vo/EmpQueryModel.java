package org.wenhanglei.auth.emp.vo;

import java.util.Date;

/**
 * @author: wenhanglei
 * @date: 2019/9/12
 * @time: 15:57
 * @info:
 */
public class EmpQueryModel extends EmpModel{

  /**
   * 上次登录截止时间
   * @return
   */
  private Date lastLoginTimeTo;

  public Date getLastLoginTimeTo() {
    return lastLoginTimeTo;
  }

  public void setLastLoginTimeTo(Date lastLoginTimeTo) {
    this.lastLoginTimeTo = lastLoginTimeTo;
  }
}
