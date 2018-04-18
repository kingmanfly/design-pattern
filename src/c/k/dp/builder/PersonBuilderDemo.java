package c.k.dp.builder;
class Person {
    private String head;
    private String body;
    private String footer;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }
}

class Man extends Person{
    public Man() {
        System.out.println("开始建造男人");
    }
}

class Woman extends Person{
    public Woman() {
        System.out.println("开始建造女人");
    }
}

interface PersonBuilder{
    void buildHead();
    void buildBody();
    void buildFooter();
    Person buildPerson();
}

class ManBuilder implements PersonBuilder{
    Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("构造男人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("构造男人的身体");
    }

    @Override
    public void buildFooter() {
        person.setFooter("构造男人的脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "ManBuilder{" +
                "person=" + person +
                '}';
    }
}

class WomanBuilder implements PersonBuilder{
    Person person;

    public WomanBuilder() {
        person = new Woman();
    }

    @Override
    public void buildHead() {
        person.setHead("构造女人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("构造女人的身体");
    }

    @Override
    public void buildFooter() {
        person.setFooter("构造女人的脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}

class PersonDirector{
    public Person constructPerson(PersonBuilder pb){
        pb.buildHead();
        pb.buildBody();
        pb.buildFooter();
        return pb.buildPerson();
    }
}
public class PersonBuilderDemo {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person womanPerson = pd.constructPerson(new ManBuilder());
        System.out.println(womanPerson.toString());
        Person manPerson = pd.constructPerson(new WomanBuilder());
        System.out.println(manPerson.toString());
    }
}
