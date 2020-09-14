package com.example.demo.expt;

import com.alibaba.cola.extension.Extension;
import com.example.demo.model.Department;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension(bizId = "organize",useCase = "getByCorpId",scenario = "dingTalk")
public class DingTalkOrganizationExt implements OrganizationExtPt {
  private static final Logger log = LoggerFactory.getLogger(DingTalkOrganizationExt.class);

  @Override
  public List<Department> getDepartmentsByCorpId(String corpId, Boolean includeDelete) {
    log.info("在组织结构业务，通过企业编号获取部门列表的用例，在钉钉的场景下业务的实现处理方式");

    log.info("通过钉钉的配置信息和API获取得到组织信息，并组装成云枢识别的部门信息");

    Department department = new Department();

    department.setName("dingTalk");
    department.setCorpId(corpId);

    return Collections.singletonList(department);
  }
}
