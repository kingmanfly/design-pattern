package c.k.dp.singleton;

/**
 * 这个类可以简单的满足多线程，在性能上会有所下降
 *
 * 实现原理： synchronized关键字锁住的是这个对象，因为每次调用getInstance()，
 * 都要对对象上锁，其他线程就要等待
 */
public class SingletonMultiThread1 {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static SingletonMultiThread1 instance = null;

    /* 私有构造方法，防止被实例化 */
    private SingletonMultiThread1() {
    }

    /* 静态工程方法，创建实例 */
    public static synchronized SingletonMultiThread1 getInstance(){
        if(instance == null){
            instance = new SingletonMultiThread1();
        }
        return instance;
    }
}
