/**
 * 命令模式
 * <p>
 * 将来自客户端的请求传入一个对象，从而使你可用不同的请求对客户进行参数化。
 * 用于“行为请求者”与“行为实现者”解耦，可实现二者之间的松耦合，以便适应变化。分离变化与不变的因素。
 * <p>
 * 模拟对电视机的操作有开机、关机、换台命令。
 */
package c.k.dp.command;

/**
 * 执行命令的接口
 */
interface Command {
    void execute();
}

/**
 * 命令接收者Receiver
 */
class Tv {
    public int currentChannel = 0;

    public void turnOn() {
        System.out.println("The televisino is on.");
    }

    public void turnOff() {
        System.out.println("The television is off.");
    }

    public void changeChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Now TV channel is " + channel);
    }
}

/**
 * 开机命令ConcreteCommand
 */
class CommandOn implements Command {
    private Tv myTv;

    public CommandOn(Tv myTv) {
        this.myTv = myTv;
    }

    @Override
    public void execute() {
        myTv.turnOn();
    }
}

/**
 * 关机命令ConcreteCommand
 */
class CommandOff implements Command {
    private Tv myTv;

    public CommandOff(Tv myTv) {
        this.myTv = myTv;
    }

    @Override
    public void execute() {
        myTv.turnOff();
    }
}

/**
 * 频道切换命令ConcreteCommand
 */
class CommandChange implements Command {
    private Tv myTv;
    private int channel;

    public CommandChange(Tv myTv, int channel) {
        this.myTv = myTv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        myTv.changeChannel(channel);
    }
}

/**
 * 可以看作是遥控器Invoker
 */
class Control{
    private Command onCommand, offCommand, changeChannel;

    public Control(Command onCommand, Command offCommand, Command changeChannel) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
        this.changeChannel = changeChannel;
    }

    public void turnOn(){
        onCommand.execute();
    }

    public void turnOff(){
        offCommand.execute();
    }

    public void changeChannel(){
        changeChannel.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args){
        // 命令接收者Receiver
        Tv tv = new Tv();

        // 开机命令ConcreteCommond
        CommandOn on = new CommandOn(tv);

        // 关机命令ConcreteCommond
        CommandOff off = new CommandOff(tv);

        // 频道切换命令ConcreteCommond
        CommandChange channel = new CommandChange(tv, 2);

        // 命令控制对象Invoker
        Control control = new Control(on, off, channel);

        // 开机
        control.turnOn();

        // 切换频道
        control.changeChannel();

        // 关机
        control.turnOff();
    }
}
