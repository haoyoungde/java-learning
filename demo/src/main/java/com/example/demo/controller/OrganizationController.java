package com.example.demo.controller;


import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.alibaba.cola.extension.ExtensionRepository;
import com.example.demo.expt.OrganizationExtPt;
import com.example.demo.model.Department;
import com.example.demo.model.OrganizationQry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {
  @Autowired
  private ExtensionExecutor extensionExecutor;

  @Autowired
  private ExtensionRepository extensionRepository;

  @GetMapping(value = "/organization/getDepartmentsByCorpId/{corpId}/{scenario}")
  public MultiResponse<Department> listCustomerByName(@PathVariable("corpId") String corpId, @PathVariable("scenario") String scenario){

    extensionRepository.getExtensionRepo().forEach((arg, arg2) -> {
      System.out.println(arg.getBizScenario());
    });

    OrganizationQry qry = new OrganizationQry();
    qry.setCorpId(corpId);
    qry.setIncludeDelete(true);
    qry.setBizScenario(BizScenario.valueOf("organize","getByCorpId",scenario));

    List<Department> departmentList = extensionExecutor.execute(OrganizationExtPt.class, qry.getBizScenario(),
            ex -> ex.getDepartmentsByCorpId(corpId, qry.isIncludeDelete()));

    System.out.println(departmentList);

    return MultiResponse.ofWithoutTotal(departmentList);
  }
}
