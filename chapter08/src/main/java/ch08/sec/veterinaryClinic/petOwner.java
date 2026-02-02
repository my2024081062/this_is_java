package ch08.sec.veterinaryClinic;

import lombok.Getter;

@Getter
public class petOwner extends Human{
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private final Pet[] pets;

    public petOwner(String name, Pet[] pets) {
        super(name);
        this.pets = pets;
    }

    public void requestCareAnimal(Pet a, Veterinarian v, Nurse n){
        v.AnimalCare(a,this,n);
    }

    public void visitAnimal(Pet a, Nurse n){
        n.animalOwnersRequestVisitAnimal(a);
    }


}
