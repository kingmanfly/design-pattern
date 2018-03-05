package c.k.dp.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProxyTest {

    @Test
    public void testProxy(){
        Sourceable source = new Proxy();
        source.method();
    }
}