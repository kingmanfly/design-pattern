package c.k.dp.state.lifter;

/**
 * 模拟电梯的动作
 */
public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
