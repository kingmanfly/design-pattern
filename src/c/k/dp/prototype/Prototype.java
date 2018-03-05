package c.k.dp.prototype;

public class Prototype implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }
}
