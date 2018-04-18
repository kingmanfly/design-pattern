package c.k.dp.factorymethod;

abstract class BMW{

}

class BMW320 extends BMW{
    public BMW320() {
        System.out.println("制造-->BMW320");
    }
}

class BMW523 extends BMW{
    public BMW523() {
        System.out.println("制造-->BMW523");
    }
}

class Factory{
    public BMW createBMW(int type){
        switch (type){
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
        }
        return null;
    }
}
public class SimpleFactoryCarDemo {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
