package c.k.dp.flyweight;

import java.util.Hashtable;

abstract class AFlyweight{
    public abstract void operation();
}

class ConcreteFlyweight extends AFlyweight{
    private String string;

    public ConcreteFlyweight(String string) {
        this.string = string;
    }

    @Override
    public void operation() {
        System.out.println("Concrete---Flyweight : " + string);
    }
}

class FlyweightFactory{
    private Hashtable flyweights = new Hashtable();
    public AFlyweight getFlyWeight(Object obj){
        AFlyweight flyweight = (AFlyweight) flyweights.get(obj);
        if(flyweight == null){
            //产生新的ConcreteFlyweight
            flyweight = new ConcreteFlyweight((String)obj);
            flyweights.put(obj, flyweight);
        }
        return flyweight;
    }

    public int getFlyweightSize(){
        return flyweights.size();
    }
}
class FlyweightPattern{
    FlyweightFactory factory = new FlyweightFactory();
    AFlyweight fly1;
    AFlyweight fly2;
    AFlyweight fly3;
    AFlyweight fly4;
    AFlyweight fly5;
    AFlyweight fly6;

    public FlyweightPattern() {
        fly1 = factory.getFlyWeight("Google");
        fly2 = factory.getFlyWeight("Qutr");
        fly3 = factory.getFlyWeight("Google");
        fly4 = factory.getFlyWeight("Google");
        fly5 = factory.getFlyWeight("Google");
        fly6 = factory.getFlyWeight("Google");
    }

    public void showFlyweight(){
        fly1.operation();
        fly2.operation();
        fly3.operation();
        fly4.operation();
        fly5.operation();
        fly6.operation();

        int objSize = factory.getFlyweightSize();
        System.out.println("objSize = " + objSize);
    }
}
public class FlyweightDemo {
    public static void main(String[] args){
        System.out.println("The FlyWeight Pattern!");
        FlyweightPattern fp = new FlyweightPattern();
        fp.showFlyweight();
    }
}
