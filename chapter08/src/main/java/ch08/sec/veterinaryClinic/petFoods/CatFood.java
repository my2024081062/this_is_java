package ch08.sec.veterinaryClinic.petFoods;


public class CatFood {
    private final static CatFood catFood = new CatFood();

    private CatFood(){

    }
    public static CatFood getInstance(){
        return CatFood.catFood;
    }
}
