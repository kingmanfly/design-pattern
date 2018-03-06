package c.k.dp.memento;

import org.junit.Test;

import static org.junit.Assert.*;

public class MementoTest {

    @Test
    public void use(){
        /* 创建原始类 */
        Original origi = new Original("egg");

        /* 创建备忘录 */
        Storage storage = new Storage(origi.createMemento());

        /* 修改原始类的状态 */
        System.out.println("初始化状态为：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为：" + origi.getValue());

        /* 恢复原始类的状态 */
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + origi.getValue());
    }
}