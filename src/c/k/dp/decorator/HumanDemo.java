package c.k.dp.decorator;

interface Human{
    void wearClothes();
    void walkToWhere();
}

//定义装饰者
abstract class HumanDecorator implements Human{
    private Human human;

    public HumanDecorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
    }
}

class DecoratorZero extends HumanDecorator{

    public DecoratorZero(Human human) {
        super(human);
    }

    public void goHome(){
        System.out.println("进房子。。");
    }

    public void findMap(){
        System.out.println("书房找找Map。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}

class DecoratorOne extends HumanDecorator{

    public DecoratorOne(Human human) {
        super(human);
    }
    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }
}

class DecoratorTwo extends HumanDecorator{

    public DecoratorTwo(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("找到一件D&G。。");
    }

    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }
}

class People implements Human{
    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。");
    }
}

public class HumanDemo {
    public static void main(String[] args) {
        Human people = new People();
        HumanDecorator decorator = new DecoratorTwo(new DecoratorOne(new DecoratorZero(people)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
