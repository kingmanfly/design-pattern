package c.k.dp.command.impl;

import c.k.dp.command.Receiver;
import c.k.dp.command.interf.Command;

public class MyCommand implements Command {
    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
