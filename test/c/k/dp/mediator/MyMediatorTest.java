package c.k.dp.mediator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMediatorTest {

    @Test
    public void workAll() {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}