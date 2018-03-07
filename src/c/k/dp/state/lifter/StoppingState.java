package c.k.dp.state.lifter;

/**
 * 在停止状态下能做什么事情
 */
public class StoppingState extends LiftState {

    @Override
    public void close() {
        // do nothing;
    }

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);

        // 动作委托为OpeningState来执行
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);

        // 动作委托为RunningState来执行
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
        //通过代码来让电梯停止
    }
}
