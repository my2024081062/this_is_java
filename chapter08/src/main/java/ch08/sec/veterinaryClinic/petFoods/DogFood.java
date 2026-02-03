package ch08.sec.veterinaryClinic.petFoods;

public class DogFood {
    private final static DogFood food = new DogFood();

    private DogFood(){

    }
    public static DogFood getInstance(){
        return DogFood.food;
    }
}
