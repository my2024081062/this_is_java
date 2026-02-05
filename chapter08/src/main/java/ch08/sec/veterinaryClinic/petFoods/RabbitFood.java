package ch08.sec.veterinaryClinic.petFoods;

import ch08.sec.veterinaryClinic.EnableAnimal;
import ch08.sec.veterinaryClinic.PetFood;
import lombok.Getter;

@Getter
public class RabbitFood extends PetFood {
    private final EnableAnimal enableAnimal = EnableAnimal.RABBIT;
    private final static RabbitFood food = new RabbitFood();

    private RabbitFood(){
        super(EnableAnimal.RABBIT);
    }
    public static RabbitFood getInstance(){
        return RabbitFood.food;
    }

}
