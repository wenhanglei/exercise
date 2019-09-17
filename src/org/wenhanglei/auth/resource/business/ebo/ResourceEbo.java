package org.wenhanglei.auth.resource.business.ebo;

import org.wenhanglei.auth.resource.business.ebi.ResourceEbi;
import org.wenhanglei.auth.resource.dao.dao.ResourceDao;

/**
 * @author: wenhanglei
 * @date: 2019/9/17
 * @time: 14:48
 * @info:
 */
public class ResourceEbo implements ResourceEbi {

  private ResourceDao resourceDao;
  public void setResourceDao(ResourceDao resourceDao) {
    this.resourceDao = resourceDao;
  }
}
