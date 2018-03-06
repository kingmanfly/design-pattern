package c.k.dp.interpreter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlusTest {

    @Test
    public void interpret() {
        Assert.assertEquals(11, new Plus().interpret(new Context(9, 2)));
    }
}