package c.k.dp.singleton;

/**
 * 多线程单例模式 使用内部类来维护单例的实现
 *
 * 实现原理： JVM内部的机制能够保证当一个类被加载的时候，
 * 这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，
 * JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕

 */
public class SingletonMultiThread3 {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static SingletonMultiThread3 instance = null;

    /* 私有构造方法，防止被实例化 */
    private SingletonMultiThread3() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        //如果在构造函数中抛出异常，实例将永远得不到创建，也会出错
        private static SingletonMultiThread3 instance = new SingletonMultiThread3();
    }


    /* 静态工程方法，获取实例 */
    public static synchronized SingletonMultiThread3 getInstance(){
        return SingletonFactory.instance;
    }
}
