package com.haoyoungde.path;

import java.io.IOException;
import java.io.InputStream;

public class Path {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        System.out.println(Path.class.getResource("config_in_package.properties"));
        System.out.println(Path.class.getResource("/config.properties"));

        //Module API 总是使用绝对名称，因此顶级资源不需要前导斜杠。
        System.out.println(Path.class.getModule().getResourceAsStream("com/haoyoungde/path/config_in_package.properties"));
        System.out.println(Path.class.getModule().getResourceAsStream("config.properties"));
    }
}
