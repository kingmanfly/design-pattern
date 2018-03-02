package c.k.dp.abstractfactory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsageTest {

    @Test
    public void invokeSendMailFactory() {
        Usage usage = new Usage();
        Assert.assertEquals("this is mail sender!",usage.invokeSendMailFactory());
    }

    @Test
    public void invokeSendSmsFactory() {
        Usage usage = new Usage();
        Assert.assertEquals("this is sms sender!",usage.invokeSendSmsFactory());
    }
}