package c.k.dp.mediator.within;

/**
 * 中介者模式
 * 用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，
 * 从而使耦合松散，而且可以独立地改变它们之间的交互。
 *
 * 有两个类A和B，类中各有一个数字，并且要保证类B中的数字永远是类A中数字的100倍。
 * 也就是说，当修改类A的数时，将这个数字乘以100赋给类B，而修改类B时，要将数除以100赋给类A。
 * 类A类B互相影响，就称为同事类
 */

abstract class AbstractColleague{
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    //注意这里的参数不再是同事类，而是一个中介者
    abstract void setNumber(int number, AbstractMediator am);
}

class ColleagueA extends AbstractColleague{

    @Override
    void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}

class ColleagueB extends AbstractColleague{

    @Override
    void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}

abstract class AbstractMediator{
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }
    abstract void AaffectB();
    abstract void BaffectA();
}

class Mediator extends AbstractMediator{
    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    @Override
    void AaffectB() {   //处理A对B的影响
        int number = A.getNumber();
        B.setNumber(number*100);
    }

    @Override
    void BaffectA() {   //处理B对A的影响
        int number = B.getNumber();
        A.setNumber(number/100);
    }
}
public class MediatorClient {
    public static void main(String[] args){
        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        AbstractMediator am = new Mediator(collA, collB);

        System.out.println("==========通过设置A影响B==========");
        collA.setNumber(1000, am);
        System.out.println("collA的number值为："+collA.getNumber());
        System.out.println("collB的number值为A的10倍："+collB.getNumber());

        System.out.println("==========通过设置B影响A==========");
        collB.setNumber(1000, am);
        System.out.println("collB的number值为："+collB.getNumber());
        System.out.println("collA的number值为B的0.01倍："+collA.getNumber());
    }
}
