package c.k.dp.strategy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    Client client = new Client();
    @Test
    public void plus() {
        Assert.assertEquals(10, client.plus("2+8"));
    }

    @Test
    public void minus() {
        Assert.assertEquals(9, client.minus("12-3"));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(16, client.multiply("2*8"));
    }
}