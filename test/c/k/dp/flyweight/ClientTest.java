package c.k.dp.flyweight;

import org.junit.Test;

public class ClientTest {
    @Test
    public void testSimpleFlyweight(){
        Client client = new Client();
        client.simpleFlyweight();
    }

    @Test
    public void testUnSharedFlyweight() {
        Client client = new Client();
        client.unSharedFlyweight();
    }

    @Test
    public void testCompositeFlyweight() {
        Client client = new Client();
        client.compositeFlyweight();
    }
}