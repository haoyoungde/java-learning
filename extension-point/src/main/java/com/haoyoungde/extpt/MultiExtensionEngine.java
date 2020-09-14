package com.haoyoungde.extpt;

public class MultiExtensionEngine implements Engine {
  public MultiExtensionEngine() {
    // 注册扩展
    ExtensionBuilder.getInstance().build();
  }

  @Override
  public String process(String bizCode, String params) {
    StringBuilder processRecord = new StringBuilder();

    PreAndPostExtension preAndPostExtension = ExtensionBuilder.getInstance().getExt(PreAndPostExtension.class, bizCode);
    ModifyExtension1 modifyExtension1 = ExtensionBuilder.getInstance().getExt(ModifyExtension1.class, bizCode);
    ModifyExtension2 modifyExtension2 = ExtensionBuilder.getInstance().getExt(ModifyExtension2.class, bizCode);

    // 1、前置处理
    preAndPostExtension.beforeProcess(params, processRecord);
    // 2、统一处理1
    System.out.println("统一处理流程1");
    processRecord.append("统一处理1 - ");
    // 3、过程处理1
    modifyExtension1.modify(params,processRecord);
    // 4、统一处理2
    System.out.println("统一处理流程2");
    processRecord.append("统一处理2 - ");
    // 5、过程处理2
    modifyExtension2.modify(params,processRecord);
    // 6、统一处理3
    System.out.println("统一处理流程3");
    processRecord.append("统一处理3 - ");
    // 7、后置处理
    preAndPostExtension.afterProcess(params, processRecord);

    return processRecord.toString();
  }
}
