package ch08.sec.veterinaryClinic;

import ch08.sec.veterinaryClinic.petCharts.*;
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
    private boolean work_from_8_to_16;

    public Nurse(String name, boolean work_from_8_to_16) {
        super(name);
        this.work_from_8_to_16 = work_from_8_to_16;
    }
    public void animalOwnersRequestVisitAnimal(Pet a){
        Clinic cli = Clinic.getInstance();
        if(LocalTime.now().getHour() >= 15 && LocalTime.now().getHour() <= 20){
            for(PetChart ac : cli.getPetCharts()){
                if(a.getId() == ac.getPet().getId()){
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

    public void veterinarianRequestHospitalizationAnimal(Pet pet, PetOwner petOwner,Approximately approximately ,Veterinarian veterinarian, int day){
        Clinic cli = Clinic.getInstance();
        PetChart ac = switch (pet.getEnableAnimal()){
            case EnableAnimal.CAT -> {
                yield new CatChart(pet,veterinarian,petOwner, approximately, LocalDate.now(),LocalDate.now().plusDays(day));
            }
            case EnableAnimal.DOG -> {
                yield new DogChart(pet,veterinarian,petOwner, approximately,LocalDate.now(),LocalDate.now().plusDays(day));
            }
            case EnableAnimal.CHICKEN -> {
                yield new ChickenChart(pet,veterinarian,petOwner, approximately,LocalDate.now(),LocalDate.now().plusDays(day));
            }
            case EnableAnimal.RABBIT -> {
                yield new RabbitChart(pet,veterinarian,petOwner, approximately,LocalDate.now(),LocalDate.now().plusDays(day));
            }
            case EnableAnimal.PARROT -> {
                    yield new ParrotChart(pet,veterinarian,petOwner, approximately,LocalDate.now(),LocalDate.now().plusDays(day));
            }
            case EnableAnimal.HEDGEHOG -> {
                yield new HedgehogChart(pet,veterinarian,petOwner, approximately,LocalDate.now(),LocalDate.now().plusDays(day));
            }
        };
        cli.addAnimalChart(ac);
    }
}