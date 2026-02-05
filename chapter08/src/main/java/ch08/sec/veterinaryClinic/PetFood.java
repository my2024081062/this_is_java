package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetFood {
    protected EnableAnimal enableAnimal = null;
    private int amount = 0;
    protected PetFood(EnableAnimal enableAnimal){
        this.enableAnimal = enableAnimal;
    }
    public PetFood(){
        this(null);
    }
    public void addFood(int amount){
        this.setAmount(getAmount()+amount);
    }
    public void subtractFood(int amount){
        if(getAmount()<amount){
            this.setAmount(0);
        }
        else{
            this.setAmount(getAmount()-amount);
        }
    }
}
