package c.k.dp.decorator;

import org.junit.Test;

public class DecoratorTest {

    @Test
    public void testDecorator(){
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }

}