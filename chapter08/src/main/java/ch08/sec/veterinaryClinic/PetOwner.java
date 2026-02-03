package ch08.sec.veterinaryClinic;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class PetOwner extends Human{
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private final Pet[] pets;

    public PetOwner(String name, Pet[] pets) {
        super(name);
        this.pets = pets;
    }

    public void requestCareAnimal(Pet a, Veterinarian v, Nurse n){
        v.AnimalCare(a,this);
    }

    public void visitAnimal(Pet a){
        Clinic cli = Clinic.getInstance();
        if(LocalTime.now().getHour() >= 8 && LocalTime.now().getHour() < 16){
            int headcount = cli.getNurses0816().length;
            if(headcount == 0) {
                return;
            }
            cli.getNurses0816()[(int)(Math.random()*headcount)].animalOwnersRequestVisitAnimal(a);
        }
        if(LocalTime.now().getHour() >= 16){
            int headcount = cli.getNurses1624().length;
            if(headcount == 0) {
                return;
            }
            cli.getNurses1624()[(int)(Math.random()*headcount)].animalOwnersRequestVisitAnimal(a);
        }

    }


}

