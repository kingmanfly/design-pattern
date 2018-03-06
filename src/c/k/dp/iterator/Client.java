package c.k.dp.iterator;

import c.k.dp.iterator.impl.MyCollection;
import c.k.dp.iterator.interf.Collection;
import c.k.dp.iterator.interf.Iterator;

/**
 * 迭代子模式（Iterator）
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
