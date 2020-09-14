package com.haoyoungde.extpt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.reflections.Reflections;

public class ExtensionBuilder {
  private ExtensionBuilder(){}

  public static ExtensionBuilder getInstance(){
    return ExtensionBuilderHolder.EXTENSION_BUILDER;
  }

  private static class ExtensionBuilderHolder {
    private static final ExtensionBuilder EXTENSION_BUILDER = new ExtensionBuilder();
  }

  private Map<Class<? extends Extension>, Map<String, Extension>> multiExtMap =
          new ConcurrentHashMap<>();

  public void build(){
    try {
      Reflections extKindReflections = new Reflections("com.haoyoungde.extpt");
      Set<Class<? extends Extension>> extkindClasses = extKindReflections.getSubTypesOf(Extension.class);

      Set<Class<? extends ExtensionFacade>> extFacadeClasses = extKindReflections.getSubTypesOf(ExtensionFacade.class);

      for(Class<? extends Extension> extkindClass : extkindClasses){
        if(!extkindClass.isInterface()){
          continue;
        }

        Map<String, Extension> extMap = new ConcurrentHashMap<>();

        for(Class<? extends ExtensionFacade> extFacade : extFacadeClasses){
          BizCode[] annotationsByType = extFacade.getAnnotationsByType(BizCode.class);
          if(annotationsByType.length > 0){
            BizCode bizCode = annotationsByType[0];
            Extension extension = null;

            ExtensionFacade extensionFacade = extFacade.getDeclaredConstructor().newInstance();
            Method[] facadeDeclaredMethods = extFacade.getDeclaredMethods();
            for(Method facadeMethod: facadeDeclaredMethods){
              if(extkindClass.isAssignableFrom(facadeMethod.getReturnType())){
                extension = (Extension)facadeMethod.invoke(extensionFacade);
              }
            }
            if(extension != null){
              extMap.put(bizCode.value(), extension);
            }
          }
        }
        multiExtMap.put(extkindClass, extMap);
      }
    } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public <Ext> Ext getExt(Class<Ext> extClass, String bizCode) {
    return (Ext) multiExtMap.get(extClass).get(bizCode);
  }
}
