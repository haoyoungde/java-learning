package com.haoyoungde.eventbus;

import com.google.common.eventbus.EventBus;

public class MainTest {
    public static void main(String[] args) {
        B b = new B();
        EventBus eventBus = new EventBus();
        eventBus.register(b);
        A a = new A(eventBus);
        a.a1();
    }
}
