package c.k.dp.factorymethod.staticfactory;

import c.k.dp.factorymethod.Sender;
import org.junit.Test;

public class SendFactoryTest {

    @Test
    public void testPrduceSmsSender(){
        Sender sender = SendFactory.prduceSmsSender();
        sender.send();
    }
}