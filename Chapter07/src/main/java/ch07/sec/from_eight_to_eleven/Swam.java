package ch07.sec.from_eight_to_eleven;

public class Swam extends Animal1{
    @Override
    public void breath() {
        System.out.println("숨을 쉽니다." );

    }

    @Override
    public Object eat(Animal1 a) {
        return "swam은 " + a.toString() + "을 먹지 못 합니다.";
    }
}
