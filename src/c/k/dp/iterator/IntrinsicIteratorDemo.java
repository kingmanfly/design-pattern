/**
 * 黑箱聚集与内禀迭代子
 *
 * 聚集对象为迭代子对象提供一个宽接口，而为其他对象提供一个窄接口。
 * 换言之，聚集对象的内部结构应当对迭代子对象适当公开，以便迭代子对象能够对聚集对象有足够的了解，
 * 从而可以进行迭代操作。但是，聚集对象应当避免向其他的对象提供这些方法，
 * 因为其他对象应当经过迭代子对象进行这些工作，而不是直接操控聚集对象。
 */
package c.k.dp.iterator;

/**
 * 抽象迭代子角色类
 */
interface IntrinsicIterator {
    //迭代方法：移动到第一个元素
    void first();

    //迭代方法：移动到下一个元素
    void next();

    //迭代方法：是否为最后一个元素
    boolean isDone();

    //迭代方法：返还当前元素
    Object currentItem();
}

/**
 * 抽象聚集角色类
 */
abstract class IntrinsicAggregate {
    //工厂方法，创建相应迭代子对象的接口
    public abstract IntrinsicIterator createIterator();
}

/**
 * 具体聚集角色类
 */
class ConcreteIntrinsicAggregate extends IntrinsicAggregate {
    private Object[] objArray = null;

    /**
     * 构造方法，传入聚合对象的具体内容
     */
    public ConcreteIntrinsicAggregate(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public IntrinsicIterator createIterator() {
        return new ConcreteIntrinsicIterator();
    }

    /**
     * 内部成员类，具体迭代子类
     */

    private class ConcreteIntrinsicIterator implements IntrinsicIterator{
        //内部索引，记录当前迭代到的索引位置
        private int index = 0;
        //记录当前聚集对象的大小
        private int size = 0;

        public ConcreteIntrinsicIterator() {
            this.size = objArray.length;
            index = 0;
        }

        @Override
        public void first() {   //迭代方法：移动到第一个元素
            index = 0;
        }

        @Override
        public void next() {    //迭代方法：移动到下一个元素
            if(index < size){
                index ++;
            }
        }

        @Override
        public boolean isDone() {   //迭代方法：是否为最后一个元素
            return (index >= size);
        }

        @Override
        public Object currentItem() {   //迭代方法：返还当前元素
            return objArray[index];
        }
    }

    /**
     * 取值方法：向外界提供聚集的大小
     */
    public int size() {
        return objArray.length;
    }
}

public class IntrinsicIteratorDemo {
    public static void main(String[] args) {
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //创建聚合对象
        IntrinsicAggregate agg = new ConcreteIntrinsicAggregate(objArray);
        //循环输出聚合对象中的值
        IntrinsicIterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }
}
