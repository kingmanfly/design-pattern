/**
 * 适用场景：
 * 1) 当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
 * 2) 当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。
 * 3) 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之, 你不希望这些对象是紧密耦合的。
 * <p>
 * 应用：
 * 珠宝商运送一批钻石，有黄金强盗准备抢劫，珠宝商雇佣了私人保镖，警察局也派人护送，
 * 于是当运输车上路的时候，强盗保镖警察都要观察运输车一举一动，
 */
package c.k.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象的观察者
 */
interface Watcher {
    public void update();
}

/**
 * 抽象的被观察者，在其中声明方法（添加、移除观察者，通知观察者）：
 */
interface Watched {
    void addWatcher(Watcher watcher);
    void removeWatcher(Watcher watcher);
    void notifyWatchers();
}

/**
 * 具体的观察者:保镖
 */
class Security implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}

/**
 * 具体的观察者:强盗
 */
class Thief implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}

/**
 * 具体的观察者:警察
 */
class Police implements Watcher
{
    @Override
    public void update()
    {
        System.out.println("运输车有行动，警察护航");
    }
}

/**
 * 具体的被观察者
 */
class Transporter implements Watched
{
    private List<Watcher> list = new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher)
    {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher)
    {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        for (Watcher watcher : list) {
            watcher.update();
        }
    }
}

public class ObserverDeom {
    public static void main(String[] args){
        Transporter transporter = new Transporter();
        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(thief );

        transporter.notifyWatchers();
    }
}

/**
 * 我推你拉
 例子中没有关于数据和状态的变化通知，只是简单通知到各个观察者，告诉他们被观察者有行动。
 观察者模式在关于目标角色、观察者角色通信的具体实现中，有两个版本。
 一种情况便是目标角色在发生变化后，仅仅告诉观察者角色“我变化了”，
 观察者角色如果想要知道具体的变化细节，则就要自己从目标角色的接口中得到。
 这种模式被很形象的称为：拉模式——就是说变化的信息是观察者角色主动从目标角色中“拉”出来的。
 还有一种方法，那就是我目标角色“服务一条龙”，通知你发生变化的同时，
 通过一个参数将变化的细节传递到观察者角色中去。这就是“推模式”——管你要不要，先给你啦。
 这两种模式的使用，取决于系统设计时的需要。如果目标角色比较复杂，
 并且观察者角色进行更新时必须得到一些具体变化的信息，则“推模式”比较合适。如果目标角色比较简单，
 则“拉模式”就很合适啦。
 */
