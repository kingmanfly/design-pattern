package c.k.dp.flyweight.impl;

import c.k.dp.flyweight.interf.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ConcreteCompositeFlyweight implements Flyweight {
    private Map<Integer, Flyweight> labels = new HashMap<Integer, Flyweight>();

    public void add(int key, Flyweight flyweight){
        labels.put(key, flyweight);
    }

    @Override
    public void operation(String extrinsicState) {
        Flyweight flyweight = null;
        for (Object key : labels.keySet()){
            flyweight = labels.get(key);
            flyweight.operation(extrinsicState);
        }
    }
}
