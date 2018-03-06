package c.k.dp.flyweight.impl;

import c.k.dp.flyweight.interf.Flyweight;

public class UnsharedConcreteFlyweight implements Flyweight{
    private String intrinsicState = null;

    public UnsharedConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("内蕴状态：" + intrinsicState);
        System.out.println("外蕴状态：" + extrinsicState);
    }
}
