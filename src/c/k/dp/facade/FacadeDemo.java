package c.k.dp.facade;
class ModuleA{
    public void testA(){
        System.out.println("调用ModuleA中的testA方法");
    }
}

class ModuleB{
    public void testB(){
        System.out.println("调用ModuleA中的testB方法");
    }
}

class ModuleC{
    public void testC(){
        System.out.println("调用ModuleA中的testC方法");
    }
}

class Facade{
    //示意方法，满足客户端需要的功能
    public void test(){
        ModuleA a = new ModuleA();
        a.testA();

        ModuleB b = new ModuleB();
        b.testB();

        ModuleC c = new ModuleC();
        c.testC();
    }
}
public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.test();
    }
}
