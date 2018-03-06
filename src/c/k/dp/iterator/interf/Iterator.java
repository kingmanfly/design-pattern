package c.k.dp.iterator.interf;

public interface Iterator {
    /* 前移 */
    public Object previous();

    /* 后移 */
    Object next();

    boolean hasNext();

    /* 取得第一个元素 */
    Object first();
}
