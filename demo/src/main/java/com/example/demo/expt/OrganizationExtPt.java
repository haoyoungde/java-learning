package com.example.demo.expt;

import com.alibaba.cola.extension.ExtensionPointI;
import com.example.demo.model.Department;
import java.util.List;

public interface OrganizationExtPt extends ExtensionPointI {

  List<Department> getDepartmentsByCorpId(String corpId, Boolean includeDelete);
}
