package c.k.dp.iterator;

import c.k.dp.iterator.impl.MyCollection;
import c.k.dp.iterator.interf.Collection;
import c.k.dp.iterator.interf.Iterator;

/**
 * 迭代子模式（Iterator）又叫游标(Cursor)模式，是对象的行为模式。
 * 迭代子模式可以顺序地访问一个聚集中的元素而不必暴露聚集的内部表象（internal representation）。
 *
 * 迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见。
 * 这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
 */
public class Client {
    public void use(){
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
