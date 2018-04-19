package c.k.dp.proxy;

interface IBugCar{
    void buyCar();
}

class People implements IBugCar{
    private int cash;
    private String vip;
    private String username;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void buyCar() {
        System.out.println("I real buy a car");
    }
}
class ProxyPeople implements IBugCar{
    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public void buyCar() {
        if (people.getVip() == "vip"){
            System.out.println("有权有势" + people.getUsername() + "别提钱的事");
            people.buyCar();
            return;
        }

        if(people.getCash() > 50000){
            System.out.println("有钱人" + people.getUsername() + "可以买车");
            people.buyCar();
        }else {
            System.out.println(people.getUsername()+"钱不够，不能买车，继续比赛！");
        }
    }
}
public class BuyCarDemo {
    public static void main(String[] args) {
        People zhangsan = new People();
        zhangsan.setCash(60000);
        zhangsan.setUsername("ZhangSan");

        People lisi = new People();
        lisi.setCash(40000);
        lisi.setUsername("Lisi");

        People wangwu = new People();
        wangwu.setCash(0);
        wangwu.setVip("vip");
        wangwu.setUsername("WangWu");

        ProxyPeople proxyPeople = new ProxyPeople();
        proxyPeople.setPeople(zhangsan);
        proxyPeople.buyCar();

        proxyPeople.setPeople(lisi);
        proxyPeople.buyCar();

        proxyPeople.setPeople(wangwu);
        proxyPeople.buyCar();
    }
}
