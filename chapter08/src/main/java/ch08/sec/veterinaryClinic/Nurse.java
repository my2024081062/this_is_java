package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.temporal.ChronoUnit;
@Getter
@Setter
public class Nurse extends Human{
    private static int nurse_id = 0;
    private final int id = nurse_id++;

    public Nurse(String name) {
        super(name);
    }
    public void animalOwnersRequestVisitAnimal(Pet a){
        Clinic cli = Clinic.getInstance();
        if(LocalTime.now().getHour() >= 15 && LocalTime.now().getHour() <= 20){
            for(PetChart ac : cli.getPetCharts()){
                if(a.getId() == ac.getAnimalId()){
                    if(ac.getVisitable()[(int) ChronoUnit.DAYS.between(ac.getEnterClinicDate(), LocalDate.now())]) {
                        ac.getVisitable()[(int) ChronoUnit.DAYS.between(ac.getEnterClinicDate(), LocalDate.now())] = false;
                        System.out.println("방문 요청을 처리했습니다.");
                    }
                    else{
                        System.out.println("오늘 이미 면회 하였습니다.");
                    }
                }
            }
        }
        else{
            System.out.println("동물 주인이 아니거나 방문시간이 아닙니다.");
        }
    }

    public void veterinarianRequestHospitalizationAnimal(Pet a, PetOwner ao, Veterinarian v, int day){
        Clinic cli = Clinic.getInstance();
        PetChart ac = new PetChart(a,v,ao,LocalDate.now(),LocalDate.now().plusDays(day));
        cli.addAnimalChart(ac);
    }
}