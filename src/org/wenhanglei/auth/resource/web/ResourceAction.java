package org.wenhanglei.auth.resource.web;

import com.opensymphony.xwork2.ActionSupport;
import org.wenhanglei.auth.resource.business.ebi.ResourceEbi;
import org.wenhanglei.auth.resource.vo.ResourceModel;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:49
 * @info:
 */
public class ResourceAction extends ActionSupport {

  public ResourceModel resM = new ResourceModel();

  private ResourceEbi resourceEbi;
  public void setResourceEbi(ResourceEbi resourceEbi) {
    this.resourceEbi = resourceEbi;
  }


  /**
   * 返回资源列表
   * @return
   */
  public String list(){
    return "list";
  }
}
