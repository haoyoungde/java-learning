package com.example.demo.expt;

import com.alibaba.cola.extension.Extension;
import com.example.demo.model.Department;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension(bizId = "organize",useCase = "getByCorpId",scenario = "wechat")
public class WechatOrganizationExt  implements OrganizationExtPt {
  private static final Logger log = LoggerFactory.getLogger(WechatOrganizationExt.class);

  @Override
  public List<Department> getDepartmentsByCorpId(String corpId, Boolean includeDelete) {

    log.info("业务：组织机构，用例：通过企业编号获取部门 , 场景：企业微信");

    log.info("通过企业微信的API获取组织的部门信息，然后包装为需要的部门列表");

    Department department = new Department();

    department.setName("wechat");
    department.setCorpId(corpId);

    return Collections.singletonList(department);
  }
}