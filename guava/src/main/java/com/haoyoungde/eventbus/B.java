package com.haoyoungde.eventbus;

import com.google.common.eventbus.Subscribe;

public class B {
    @Subscribe
    public void xxx(String msg){
        System.out.println("hello, " + msg);
    }
}
