package c.k.dp.templatemethod;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    Client client = new Client();
    @Test
    public void plus() {
        Assert.assertEquals(16, client.plus("8+8"));
    }

    @Test
    public void minus() {
        Assert.assertEquals(0, client.minus("8-8"));
    }
}