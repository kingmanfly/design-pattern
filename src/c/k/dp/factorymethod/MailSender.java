package c.k.dp.factorymethod;

public class MailSender implements Sender{
    @Override
    public String send() {
        String result = "this is mail sender!";
        System.out.println(result);
        return result;
    }
}
