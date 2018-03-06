package c.k.dp.flyweight.impl;

import c.k.dp.flyweight.interf.Flyweight;

/**
 * ConcreteFlyweight 必须是可共享的，它保存的任何状态都必须是内部(intrinsic),
 * 也就是说, ConcreteFlyweight 必须和它的应用环境场合无关.
 */
public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState = null;

    /**
     * 构造函数 内蕴状态作为参数传入
     */
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    /**
     * 外蕴状态作为参数传入方法中 改变方法的行为 但是并不改变对象的内蕴状态
     */
    @Override
    public void operation(String extrinsicState) {
        System.out.println("内蕴状态：" + intrinsicState);
        System.out.println("外蕴状态：" + extrinsicState);
    }
}
