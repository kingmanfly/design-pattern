/**
 * 白箱聚集与外禀迭代子
 *
 * 如果聚集对象为所有对象提供同一个接口，也就是宽接口的话，当然会满足迭代子模式对迭代子对象的要求。
 * 但是，这样会破坏对聚集对象的封装。这种提供宽接口的聚集叫做白箱聚集
 *
 * 由于迭代子是在聚集结构之外的，因此这样的迭代子又叫做外禀迭代子（Extrinsic Iterator）。
 */
package c.k.dp.iterator;

/**
 * 抽象迭代子角色类
 */
interface Iterator {
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
 * 具体迭代子角色类
 */
class ConcreteIterator implements Iterator {
    //持有被迭代的具体的聚合对象
    private ConcreteAggregate agg;
    //内部索引，记录当前迭代到的索引位置
    private int index = 0;
    //记录当前聚集对象的大小
    private int size = 0;

    public ConcreteIterator(ConcreteAggregate agg) {
        this.agg = agg;
        this.size = agg.size();
        index = 0;
    }

    /**
     * 迭代方法：返还当前元素
     */
    @Override
    public Object currentItem() {
        return agg.getElement(index);
    }

    @Override
    public void first() {   //迭代方法：移动到第一个元素
        index = 0;
    }

    @Override
    public boolean isDone() {   //迭代方法：是否为最后一个元素
        return (index >= size);
    }

    @Override
    public void next() {    //迭代方法：移动到下一个元素
        if (index < size) {
            index++;
        }
    }
}

/**
 * 抽象聚集角色类
 */
abstract class Aggregate {
    //工厂方法，创建相应迭代子对象的接口
    public abstract Iterator createIterator();
}

/**
 * 具体聚集角色类
 */
class ConcreteAggregate extends Aggregate {
    private Object[] objArray = null;

    /**
     * 构造方法，传入聚合对象的具体内容
     */
    public ConcreteAggregate(Object[] objArray) {
        this.objArray = objArray;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    /**
     * 取值方法：向外界提供聚集元素
     */
    public Object getElement(int index) {
        if (index < objArray.length) {
            return objArray[index];
        } else {
            return null;
        }
    }

    /**
     * 取值方法：向外界提供聚集的大小
     */
    public int size() {
        return objArray.length;
    }
}

public class ExtrinsicIteratorDemo {
    public static void main(String[] args) {
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //创建聚合对象
        Aggregate agg = new ConcreteAggregate(objArray);
        //循环输出聚合对象中的值
        Iterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }
}
