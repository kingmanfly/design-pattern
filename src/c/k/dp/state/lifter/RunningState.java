package c.k.dp.state.lifter;

/**
 * 电梯在运行状态下能做哪些动作
 */
public class RunningState extends LiftState {

    @Override
    public void close() {
        // do nothing
    }

    @Override
    public void open() {
        // do nothing
    }

    @Override
    public void run() {
        System.out.println("电梯上下跑...");
        //通过代码来让电梯上行/下行
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);

        // 动作委托为StoppingState来执行
        super.context.getLiftState().stop();
    }
}