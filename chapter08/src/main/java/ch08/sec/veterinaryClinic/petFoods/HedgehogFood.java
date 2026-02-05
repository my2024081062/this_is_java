package ch08.sec.veterinaryClinic.petFoods;

import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;
import lombok.Getter;

@Getter
public class HedgehogFood extends PetFood {
    private final EnableAnimal enableAnimal = EnableAnimal.HEDGEHOG;
    private final static HedgehogFood food = new HedgehogFood();

    private HedgehogFood(){
        super(EnableAnimal.HEDGEHOG);
    }
    public static HedgehogFood getInstance(){
        return HedgehogFood.food;
    }
}
