package c.k.dp.abstractfactory;

public class SmsSender implements Sender {
    @Override
    public String send() {
        String result = "this is sms sender!";
        System.out.println(result);
        return result;
    }
}
