package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pet implements Animal{
    private static int animal_id = 0;
    private final int id = animal_id++;
    private String name;
    private EnableAnimal enableAnimal;
    private boolean careNeed;

    @Override
    public void sound(){
        String petSound = "";
        switch (getEnableAnimal()){
            case CAT -> petSound = "야옹";
            case DOG -> petSound = "멍멍";
            case PARROT -> petSound = "앵무새소리";
            case RABBIT -> petSound = "토끼소리";
        }
        System.out.println(petSound);
    }
}
