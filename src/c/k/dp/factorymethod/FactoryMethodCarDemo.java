package c.k.dp.factorymethod;

interface FactoryBMW{
    BMW createBMW();
}

class FactoryBMW320 implements FactoryBMW {

    @Override
    public BMW createBMW() {
        return new BMW320();
    }
}

class FactoryBMW523 implements FactoryBMW{

    @Override
    public BMW createBMW() {
        return new BMW523();
    }
}
public class FactoryMethodCarDemo {
    public static void main(String[] args) {
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        BMW320 bmw320 = (BMW320) factoryBMW320.createBMW();

        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        BMW523 bmw523 = (BMW523) factoryBMW523.createBMW();
    }
}
