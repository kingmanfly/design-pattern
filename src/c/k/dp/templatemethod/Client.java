package c.k.dp.templatemethod;

/**
 * 模板方法模式
 * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，
 * 定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 */
public class Client {
    public int plus(String exp){
        AbstractCalculator cal = new Plus();
        return  cal.calculate(exp, "\\+");
    }

    public int minus(String exp){
        AbstractCalculator cal = new Minus();
        return  cal.calculate(exp, "-");
    }
}
