package ch08.sec.veterinaryClinic;

import lombok.Getter;
@Getter
public class Veterinarian extends Human {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private EnableAnimal[] enableAnimals;
    public Veterinarian(String name, EnableAnimal[] enableAnimals) {
        super(name);
        this.enableAnimals = enableAnimals;
    }

    public void AnimalCare(Pet pet, PetOwner ao, Nurse nurse){
        Clinic cli = Clinic.getInstance();
        for(EnableAnimal enableAnimal : enableAnimals){
            if(pet.getEnableAnimal() == enableAnimal){
                System.out.println(pet.getName() + "을(를) 진료합니다.");
                if(pet.isCareNeed()){
                    int day = (int)(Math.random()*4);
                    nurse.veterinarianRequestHospitalizationAnimal(pet,ao,this,day);
                    System.out.println(pet.getName() + "을(를) " + (day == 0 ? "당일" : day + "일") + " 입원 시켰습니다.");
                }
                else {
                    System.out.println(pet.getName() + "이(가) 건강하여 입원할 필요가 없습니다.");
                }
            }
            break;
        }
        System.out.println("이 동물은 진료할 수 없습니다.");
    }
}
