package c.k.dp.visitor.interf;

public interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}
