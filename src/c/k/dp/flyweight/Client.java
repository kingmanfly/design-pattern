package c.k.dp.flyweight;

import c.k.dp.flyweight.factory.FlyweightFactory;
import c.k.dp.flyweight.impl.UnsharedConcreteFlyweight;
import c.k.dp.flyweight.interf.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public void simpleFlyweight() {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fly1 = factory.factory("Hello");
        fly1.operation("ExtrinsicState-1");

        Flyweight fly2 = factory.factory("DesignPattern");
        fly2.operation("ExtrinsicState-2");

        Flyweight fly3 = factory.factory("Flyweight");
        fly3.operation("ExtrinsicState-3");

        Flyweight fly4 = factory.factory("Hello");
        fly4.operation("ExtrinsicState-4");

        System.out.println("fly1 == fly2 ? " + (fly1 == fly2));
        System.out.println("fly1 == fly3 ? " + (fly1 == fly3));
        System.out.println("fly1 == fly4 ? " + (fly1 == fly4));
    }

    public void unSharedFlyweight(){
        Flyweight fly5 = new UnsharedConcreteFlyweight("Unshared");
        fly5.operation("ExtrinsicState-5");
    }

    public void compositeFlyweight() {
        List<String> intrinsicStates = new ArrayList<String>();
        intrinsicStates.add("Hello");
        intrinsicStates.add("Java");
        intrinsicStates.add("DesignPattern");
        intrinsicStates.add("Flyweight");

        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.compositeFactory(intrinsicStates);
        Flyweight flyweight2 = factory.compositeFactory(intrinsicStates);
        System.out.println("flyweight1 == flyweight2 ? " + (flyweight1 == flyweight2));

        flyweight1.operation("复合享元-1");
        flyweight2.operation("复合享元-2");
    }
}
