package org.wenhanglei.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.wenhanglei.auth.emp.vo.EmpModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/10
 * @time: 9:40
 * @info:
 */
public class AuthInterceptor  extends AbstractInterceptor {

  public final static String LOGIN_ACTION = "org.wenhanglei.auth.emp.web.EmpAction.login";

  @Override
  public String intercept(ActionInvocation invocation) throws Exception {
    //如果当前请求时登录请求则直接放行
    String path = invocation.getAction().getClass().getName() + "." + invocation.getProxy().getMethod();
    if(LOGIN_ACTION.equals(path)){
      return invocation.invoke();
    }

    //判断session是否已经有登录用户的信息
    EmpModel loginEmp = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.LOGIN_EMP_INFO);
    if(loginEmp == null){
      //如果session中没有登录用户则跳转到登录页面
      return "login";
    }

    //如果session中有登录用户的信息则放行
    return invocation.invoke();
  }
}
