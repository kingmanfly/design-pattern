package c.k.dp.abstractfactory;

/**
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，
 * 也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则
 *
 * 这个模式的好处就是，如果你现在想增加一个功能：发即时信息，
 * 则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，
 * 无需去改动现成的代码。这样做，拓展性较好！
 */
public class Usage {
    public String invokeSendMailFactory(){
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        return sender.send();
    }

    public String invokeSendSmsFactory(){
        Provider provider = new SendSmsFactory();
        Sender sender = provider.produce();
        return sender.send();
    }
}
