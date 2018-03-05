package c.k.dp.bridge;

public class MyBridge extends Bridge {
    @Override
    public void method() {
        getSource().method();
    }
}
