package c.k.dp.state.lifter;

/**
 * 电梯门关闭以后，电梯可以做哪些事情
 */
public class ClosingState extends LiftState {

    @Override
    public void close() {
        System.out.println("电梯门关闭...");
        //通过代码来关闭电梯门
    }

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState); // 置为门敞状态

        // 动作委托为OpeningState来执行
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState); // 设置为运行状态；

        // 动作委托为RunningState来执行
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState); // 设置为停止状态；
        super.context.getLiftState().stop();
    }
}