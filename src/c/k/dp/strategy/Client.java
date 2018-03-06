package c.k.dp.strategy;

import c.k.dp.strategy.impl.Minus;
import c.k.dp.strategy.impl.Multiply;
import c.k.dp.strategy.impl.Plus;
import c.k.dp.strategy.interf.ICalculator;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，
 * 使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 *
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口
 *
 * 策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，
 * 对各种算法做封装。因此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
 */
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
