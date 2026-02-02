package ch08.sec.veterinaryClinic;

import lombok.Getter;
@Getter
public class Veterinarian extends Human {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;

    public Veterinarian(String name) {
        super(name);
    }

    public void AnimalCare(Animal animal, AnimalOwner ao, Nurse nurse){
        System.out.println(animal.getName() + "을(를) 진료합니다.");
        if(animal.isCareNeed()){
            int day = (int)(Math.random()*4);
            nurse.veterinarianRequestHospitalizationAnimal(animal,ao,this,day);
            System.out.println(animal.getName() + "을(를) " + (day == 0 ? "당일" : day + "일") + " 입원 시켰습니다.");
        }
        else {
            System.out.println(animal.getName() + "이(가) 건강하여 입원할 필요가 없습니다.");
        }
    }
}
