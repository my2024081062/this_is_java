package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AnimalOwner extends Human{
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private final Animal[] animals;

    public AnimalOwner(String name, Animal[] animals) {
        super(name);
        this.animals = animals;
    }

    public void requestCareAnimal(Animal a, Veterinarian v, Nurse n){
        v.AnimalCare(a,this,n);
    }

    public void visitAnimal(Animal a, Nurse n){
        n.animalOwnersRequestVisitAnimal(a);
    }


}
