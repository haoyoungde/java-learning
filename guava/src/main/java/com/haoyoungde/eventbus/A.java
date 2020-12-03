package com.haoyoungde.eventbus;

import com.google.common.eventbus.EventBus;

public class A {
    EventBus bus;

    public void a1(){
        bus.post("xxx");
    }

    public A(EventBus bus){
        this.bus = bus;
    }
}
