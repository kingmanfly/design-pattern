package c.k.dp.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽象元素类：
 * 接口或者抽象类，声明接受哪一类访问者访问，程序上是通过accept方法中的参数来定义的。
 * 抽象元素一般有两类方法，一部分是本身的业务逻辑，另外就是允许接收哪类访问者来访问。
 */
abstract class Element {
    abstract void accept(IVisitor visitor);
    abstract void doSomething();
}

/**
 * 元素类：实现抽象元素类所声明的accept方法，通常都是visitor.visit(this)，基本上已经形成一种定式了。
 */
class ConcreteElement1 extends Element {
    public void doSomething() {
        System.out.println("这是元素1");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element {
    public void doSomething() {
        System.out.println("这是元素2");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

/**
 * 抽象访问者：
 * 抽象类或者接口，声明访问者可以访问哪些元素，
 * 具体到程序中就是visit方法中的参数定义哪些对象是可以被访问的。
 */
interface IVisitor {
    void visit(Element element);
}

class Visitor implements IVisitor {
    @Override
    public void visit(Element element) {
        element.doSomething();
    }
}

/**
 * 结构对象：一个元素的容器，一般包含一个容纳多个不同类、不同接口的容器，
 * 如List、Set、Map等，在项目中一般很少抽象出这个角色。
 */
class ObjectStruture {
    public static List<Element> getList() {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int a = ran.nextInt(100);
            if (a > 50) {
                list.add(new ConcreteElement1());
            } else {
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}

public class VisitorDemo {
    public static void main(String[] args){
        List<Element> list = ObjectStruture.getList();
        for(Element e: list){
            e.accept(new Visitor());
        }
    }
}
