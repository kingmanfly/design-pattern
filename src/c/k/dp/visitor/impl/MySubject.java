package c.k.dp.visitor.impl;

import c.k.dp.visitor.interf.Subject;
import c.k.dp.visitor.interf.Visitor;

public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
