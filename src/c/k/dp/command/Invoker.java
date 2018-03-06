package c.k.dp.command;

import c.k.dp.command.interf.Command;

/**
 * 命令模式（Command）
 * 目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
