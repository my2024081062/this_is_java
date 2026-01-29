package ch07.sec.from_eight_to_eleven;

public class Rabbit extends Animal1{
    @Override
    public void breath() {
        System.out.println("숨을 쉽니다." );

    }

    @Override
    public Object eat(Animal1 a) {
        if(a instanceof Swam s){
            return "rabbit은 " + a.toString() + "을 먹습니다.";

        }
        else {
            return "rabbit은 " + a.toString() + "을 먹지 못 합니다.";
        }
    }
}
