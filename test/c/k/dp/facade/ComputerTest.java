package c.k.dp.facade;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
    @Test
    public void testComputer(){
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}