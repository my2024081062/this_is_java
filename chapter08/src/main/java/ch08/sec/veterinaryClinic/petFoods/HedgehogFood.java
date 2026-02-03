package ch08.sec.veterinaryClinic.petFoods;

public class HedgehogFood {
    private final static HedgehogFood food = new HedgehogFood();

    private HedgehogFood(){

    }
    public static HedgehogFood getInstance(){
        return HedgehogFood.food;
    }
}
