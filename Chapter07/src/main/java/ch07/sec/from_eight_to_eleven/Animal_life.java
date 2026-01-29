package ch07.sec.from_eight_to_eleven;

public class Animal_life {
    public void animal_life(){
        Animal1 a1 = new Swam();
        Animal1 a2 = new Rabbit();
        Animal1 a3 = new Tiger();

        a1.breath();
        System.out.println(a1.eat(a2));
        System.out.println(a1.eat(a3));

        a2.breath();
        System.out.println(a2.eat(a1));
        System.out.println(a2.eat(a3));

        a3.breath();
        System.out.println(a3.eat(a1));
        System.out.println(a3.eat(a2));
    }
}
