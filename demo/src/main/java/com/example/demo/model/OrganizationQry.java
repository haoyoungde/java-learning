package com.example.demo.model;

import com.alibaba.cola.extension.BizScenario;

public class OrganizationQry {
  private String corpId;
  private boolean includeDelete;
  private BizScenario bizScenario;

  public String getCorpId() {
    return corpId;
  }

  public void setCorpId(String corpId) {
    this.corpId = corpId;
  }

  public boolean isIncludeDelete() {
    return includeDelete;
  }

  public void setIncludeDelete(boolean includeDelete) {
    this.includeDelete = includeDelete;
  }

  public BizScenario getBizScenario() {
    return bizScenario;
  }

  public void setBizScenario(BizScenario bizScenario) {
    this.bizScenario = bizScenario;
  }
}
