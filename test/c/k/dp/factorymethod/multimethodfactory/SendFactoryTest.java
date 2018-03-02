package c.k.dp.factorymethod.multimethodfactory;

import c.k.dp.factorymethod.Sender;
import org.junit.Test;

public class SendFactoryTest {

    @Test
    public void testProduceMailSender(){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMailSender();
        sender.send();
    }
}