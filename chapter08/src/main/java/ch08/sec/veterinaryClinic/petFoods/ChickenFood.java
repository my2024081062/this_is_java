package ch08.sec.veterinaryClinic.petFoods;

import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;
import lombok.Getter;

@Getter
public class ChickenFood extends PetFood {
    private final EnableAnimal enableAnimal = EnableAnimal.CHICKEN;
    private final static ChickenFood food = new ChickenFood();

    private ChickenFood(){
        super(EnableAnimal.CHICKEN);
    }
    public static ChickenFood getInstance(){
        return ChickenFood.food;
    }
}
