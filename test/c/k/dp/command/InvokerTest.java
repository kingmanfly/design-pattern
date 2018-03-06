package c.k.dp.command;

import c.k.dp.command.interf.Command;
import c.k.dp.command.impl.MyCommand;
import org.junit.Test;

public class InvokerTest {

    @Test
    public void action() {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}