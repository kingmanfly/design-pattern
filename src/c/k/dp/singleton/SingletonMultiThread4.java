package c.k.dp.singleton;

/**
 * 将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的
 */
public class SingletonMultiThread4 {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static SingletonMultiThread4 instance = null;

    /* 私有构造方法，防止被实例化 */
    private SingletonMultiThread4() {
    }

    private static synchronized void syncInit(){
        if(instance == null){
            instance = new SingletonMultiThread4();
        }
    }
    /* 静态工程方法，创建实例 */
    public static synchronized SingletonMultiThread4 getInstance(){
        if(instance == null){
            syncInit();
        }
        return instance;
    }
}
