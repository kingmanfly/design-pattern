/**
 * 场景如下，刘备要到江东娶老婆了，走之前诸葛亮给赵云三个锦囊妙计，说是按天机拆开能解决棘手问题。
 * 场景中出现三个要素：三个妙计（具体策略类）、一个锦囊（环境类）、赵云（调用者）。
 */
package c.k.dp.strategy;

/**
 * 抽象策略类（Strategy）
 */
interface IStrategy{
    void operate();
}

/**
 * 妙计一：初到吴国
 */
class BackDoor implements IStrategy{
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备");
    }
}

/**
 * 妙计二：求吴国太开绿灯放行
 */
class GivenGreenLight implements IStrategy{

    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}

/**
 * 孙夫人断后，挡住追兵
 */
class BlackEnemy implements IStrategy{

    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}

/**
 * 环境类（Context)
 */
class Context{
    private IStrategy strategy;
    //构造函数，要你使用哪个妙计

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate(){
        this.strategy.operate();
    }

}
public class GoJiangDongDemo {
    public static void main(String[] args) {
        Context context;
        System.out.println("----------刚到吴国使用第一个锦囊---------------");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("\n");

        System.out.println("----------刘备乐不思蜀使用第二个锦囊---------------");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println("\n");

        System.out.println("----------孙权的追兵来了，使用第三个锦囊---------------");
        context = new Context(new BlackEnemy());
        context.operate();
        System.out.println("\n");
    }
}
