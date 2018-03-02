package c.k.dp.singleton;

/**
 * 多线程单例，比在方法上加synchronized 性能上会有所优化
 *
 * 在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();
 * 语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，
 * 也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，
 * 然后再去初始化这个Singleton实例。这样就可能出错了
 */
public class SingletonMultiThread1WithException {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static SingletonMultiThread1WithException instance = null;

    /* 私有构造方法，防止被实例化 */
    private SingletonMultiThread1WithException() {
    }

    /* 静态工程方法，创建实例 */
    public static synchronized SingletonMultiThread1WithException getInstance(){
        if(instance == null){
            /* 只有在第一次创建对象的时候需要加锁，之后就不需要了 */
            synchronized (instance) {
                if (instance == null) {
                    instance = new SingletonMultiThread1WithException();
                }

            }
        }
        return instance;
    }
}
