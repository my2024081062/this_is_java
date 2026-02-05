package ch08.sec.veterinaryClinic.petFoods;

import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;

public class DogFood extends PetFood {
    private final EnableAnimal enableAnimal = EnableAnimal.DOG;
    private final static DogFood food = new DogFood();

    private DogFood(){
        super(EnableAnimal.DOG);
    }
    public static DogFood getInstance(){
        return DogFood.food;
    }
}
