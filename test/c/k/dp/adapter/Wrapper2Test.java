package c.k.dp.adapter;

import org.junit.Test;

public class Wrapper2Test {

    @Test
    public void testWrapper2(){
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1();
        source1.method2();

        source2.method1();
        source2.method2();
    }
}