package c.k.dp.strategy;

import c.k.dp.strategy.impl.Minus;
import c.k.dp.strategy.impl.Multiply;
import c.k.dp.strategy.impl.Plus;
import c.k.dp.strategy.interf.ICalculator;

public class Client {
    public int plus(String exp){
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
        return  result;
    }

    public int minus(String exp){
        ICalculator cal = new Minus();
        int result = cal.calculate(exp);
        System.out.println(result);
        return  result;
    }

    public int multiply(String exp){
        ICalculator cal = new Multiply();
        int result = cal.calculate(exp);
        System.out.println(result);
        return  result;
    }
}
