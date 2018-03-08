package c.k.dp.responsibilitychain.demo;

/**
 * 抽象处理者角色(Handler)：定义出一个处理请求的接口
 */
abstract class Handler{
    //持有后继的责任对象
    protected Handler successor;

    //取值方法
    public Handler getSuccessor() {
        return successor;
    }

    //赋值方法，设置后继的责任对象
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
    abstract void handleRequest();
}

class ConcreteHandler extends Handler{
    private String name;

    public ConcreteHandler(String name) {
        this.name = name;
    }

    @Override
    void handleRequest() {  //处理方法，调用此方法处理请求
        if(getSuccessor() != null){
            System.out.println(name + "放过请求");
            getSuccessor().handleRequest();
        }else {
            System.out.println(name + "处理请求");
        }
    }
}
public class AbstractDemo {
    public static void main(String[] args){
        //组装责任链
        Handler handler1 = new ConcreteHandler("handler1");
        Handler handler2 = new ConcreteHandler("handler2");

        handler1.setSuccessor(handler2);

        handler1.handleRequest();
    }
}
