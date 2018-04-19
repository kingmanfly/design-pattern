package c.k.dp.decorator;

abstract class Humburger{
    protected  String name ;

    public String getName() {
        return name;
    }

    public abstract double getPrice();
}
class ChickenBurger extends Humburger{
    public ChickenBurger() {
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}

abstract class Condiment extends Humburger{
    public abstract String getName();
}

//生菜
class Lettuce extends Condiment{
    Humburger humburger;

    public Lettuce(Humburger humburger) {
        this.humburger = humburger;
    }

    @Override
    public double getPrice() {
        return humburger.getPrice()+1.5;
    }

    @Override
    public String getName() {
        return humburger.getName()+" 加生菜";
    }
}

//辣椒
class Chilli extends Condiment{
    Humburger humburger;

    public Chilli(Humburger humburger) {
        this.humburger = humburger;
    }

    @Override
    public double getPrice() {
        return humburger.getPrice();  //辣椒是免费的哦
    }

    @Override
    public String getName() {
        return humburger.getName()+" 加辣椒";
    }
}
public class HumburgerDemo {
    public static void main(String[] args) {
        Humburger humburger = new ChickenBurger();
        System.out.println(humburger.getName()+"  价钱："+humburger.getPrice());
        Lettuce lettuce = new Lettuce(humburger);
        System.out.println(lettuce.getName()+"  价钱："+lettuce.getPrice());
        Chilli chilli = new Chilli(humburger);
        System.out.println(chilli.getName()+"  价钱："+chilli.getPrice());
        Chilli chilli2 = new Chilli(lettuce);
        System.out.println(chilli2.getName()+"  价钱："+chilli2.getPrice());
    }
}
