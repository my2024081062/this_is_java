package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Getter
@Setter
public class AnimalChart {
    private static int animalChart_id = 0;
    private final int id = animalChart_id++;
    private Animal animal;
    private EnableAnimal enableAnimal;
    private int animalId;
    private Veterinarian veterinarian;
    private AnimalOwner animalOwner;
    private LocalDate enterClinicDate;
    private LocalDate externalClinicDate;
    private boolean[] visitable;
    private boolean isExtern;
    //Approximately[]로 약 배열로 줄 약 목록을 추가해도 될듯
    public AnimalChart(Animal animal, Veterinarian veterinarian, AnimalOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        this.animal = animal;
        this.veterinarian = veterinarian;
        this.animalOwner = animalOwner;
        this.enterClinicDate = enterClinicDate;
        this.externalClinicDate = externalClinicDate;
        this.enableAnimal = animal.getEnableAnimal();
        this.animalId = animal.getId();
        visitable = new boolean[(int) ChronoUnit.DAYS.between(this.getEnterClinicDate(), this.getExternalClinicDate())+1];
        Arrays.fill(visitable, true);
    }
}
