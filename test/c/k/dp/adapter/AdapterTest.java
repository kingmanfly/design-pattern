package c.k.dp.adapter;

import org.junit.Test;

public class AdapterTest {
    @Test
    public void testAdapter(){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}