package c.k.dp.visitor.impl;

import c.k.dp.visitor.interf.Subject;
import c.k.dp.visitor.interf.Visitor;

public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject：" + sub.getSubject());
    }
}
