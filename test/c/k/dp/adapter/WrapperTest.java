package c.k.dp.adapter;

import org.junit.Test;

public class WrapperTest {

    @Test
    public void testWrapper(){
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}