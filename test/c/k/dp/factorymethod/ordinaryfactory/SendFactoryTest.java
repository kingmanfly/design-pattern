package c.k.dp.factorymethod.ordinaryfactory;

import c.k.dp.factorymethod.Sender;
import org.junit.Assert;
import org.junit.Test;

public class SendFactoryTest {

    @Test
    public void produce() {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        Assert.assertEquals("this is sms sender!",sender.send() );
    }
}