package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Approximately {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private String name;

    public Approximately(Pet pet){
        String approximatelyName = switch (pet.getEnableAnimal()){
            case EnableAnimal.CAT -> "고양이 약";
            case EnableAnimal.DOG -> "개 약";
            case EnableAnimal.CHICKEN -> "닭 약";
            case EnableAnimal.RABBIT -> "토끼 약";
            case EnableAnimal.PARROT -> "앵무새 약";
            case EnableAnimal.HEDGEHOG -> "고슴도치 약";
        };
        this.setName(approximatelyName);
    }
}
