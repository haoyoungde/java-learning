package com.haoyoungde.extpt.jd;

import com.haoyoungde.extpt.BizCode;
import com.haoyoungde.extpt.ExtensionFacade;
import com.haoyoungde.extpt.ModifyExtension1;
import com.haoyoungde.extpt.ModifyExtension2;
import com.haoyoungde.extpt.PreAndPostExtension;

@BizCode("jd")
public class JdExtensionFacade implements ExtensionFacade {
  @Override
  public PreAndPostExtension getPreAndPostExtension() {
    return new JdPreAndPostExtension();
  }

  @Override
  public ModifyExtension1 getModifyExtension1() {
    return new JdModifyExtension1();
  }

  @Override
  public ModifyExtension2 getModifyExtension2() {
    return new JdModifyExtension2();
  }
}
