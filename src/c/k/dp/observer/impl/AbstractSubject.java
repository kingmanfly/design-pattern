package c.k.dp.observer.impl;

import c.k.dp.observer.interf.Observer;
import c.k.dp.observer.interf.Subject;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {
    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }
    }
}
