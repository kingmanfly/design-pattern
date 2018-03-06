package c.k.dp.strategy.impl;

import c.k.dp.strategy.AbstractCalculator;
import c.k.dp.strategy.interf.ICalculator;

public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
