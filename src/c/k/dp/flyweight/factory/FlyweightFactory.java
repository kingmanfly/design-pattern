package c.k.dp.flyweight.factory;

import c.k.dp.flyweight.impl.ConcreteCompositeFlyweight;
import c.k.dp.flyweight.impl.ConcreteFlyweight;
import c.k.dp.flyweight.interf.Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory {
    private Map<Integer, Flyweight> flyweights = new HashMap<Integer, Flyweight>();

    /* 单纯享元工厂 */
    public Flyweight factory(String intrinsicState){
        int hashCode = intrinsicState.hashCode();
        Flyweight fly = flyweights.get(hashCode);
        if (fly == null) {
            fly = new ConcreteFlyweight(intrinsicState);
            flyweights.put(hashCode, fly);
        }
        return fly;
    }

    /*复合享元工厂*/
    public Flyweight compositeFactory(List<String> intrinsicStates){
        ConcreteCompositeFlyweight flyweight = new ConcreteCompositeFlyweight();
        for (String intrinsicState : intrinsicStates){
            flyweight.add(intrinsicState.hashCode(), factory(intrinsicState));
        }
        return flyweight;
    }
}
