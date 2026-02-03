package ch08.sec.veterinaryClinic.petFoods;

public class ParrotPood {
    private final static ParrotPood food = new ParrotPood();

    private ParrotPood(){

    }
    public static ParrotPood getInstance(){
        return ParrotPood.food;
    }
}
