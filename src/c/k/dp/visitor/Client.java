package c.k.dp.visitor;

import c.k.dp.visitor.impl.MySubject;
import c.k.dp.visitor.impl.MyVisitor;
import c.k.dp.visitor.interf.Subject;
import c.k.dp.visitor.interf.Visitor;

/**
 * 访问者模式（Visitor）
 *
 * 访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。
 * 访问者模式适用于数据结构相对稳定算法又易变化的系统。
 */
public class Client {
    public void use(){
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
