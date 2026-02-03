package ch08.sec.veterinaryClinic.petFoods;

public class ChickenFood {
    private final static ChickenFood food = new ChickenFood();

    private ChickenFood(){

    }
    public static ChickenFood getInstance(){
        return ChickenFood.food;
    }
}
