package c.k.dp.observer;

import c.k.dp.observer.impl.MySubject;
import c.k.dp.observer.impl.Observer1;
import c.k.dp.observer.impl.Observer2;
import c.k.dp.observer.interf.Subject;

public class Client {
    public void use(){
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
