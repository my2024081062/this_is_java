package ch08.sec.veterinaryClinic.petFoods;

import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;
import lombok.Getter;

@Getter
public class ParrotPood extends PetFood {
    private final EnableAnimal enableAnimal = EnableAnimal.PARROT;
    private final static ParrotPood food = new ParrotPood();

    private ParrotPood(){
        super(EnableAnimal.PARROT);
    }
    public static ParrotPood getInstance(){
        return ParrotPood.food;
    }
}
