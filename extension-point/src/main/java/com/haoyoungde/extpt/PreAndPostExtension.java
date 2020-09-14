package com.haoyoungde.extpt;

public interface PreAndPostExtension extends Extension {
  void beforeProcess(String params, StringBuilder processRecord);
  void afterProcess(String params, StringBuilder processRecord);
}
