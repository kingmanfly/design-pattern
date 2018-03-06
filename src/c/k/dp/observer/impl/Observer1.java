package c.k.dp.observer.impl;

import c.k.dp.observer.interf.Observer;

public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
