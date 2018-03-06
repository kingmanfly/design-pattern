package c.k.dp.interpreter;

/**
 * 解释器模式（Interpreter）
 *
 * 用来做各种各样的解释器，如正则表达式等的解释器等等
 */
public class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}
