package ch08.sec.veterinaryClinic.petFoods;


import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;

public class CatFood extends PetFood {
    private final static CatFood catFood = new CatFood();

    private CatFood(){
        super(EnableAnimal.CAT);
    }
    public static CatFood getInstance(){
        return CatFood.catFood;
    }
}
