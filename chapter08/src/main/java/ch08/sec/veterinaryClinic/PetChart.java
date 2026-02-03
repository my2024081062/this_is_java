package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Getter
@Setter
public class PetChart {
    private static int animalChart_id = 0;
    private final int id = animalChart_id++;
    private Pet pet;
    private int animalId;
    private Veterinarian veterinarian;
    private petOwner animalOwner;
    private LocalDate enterClinicDate;
    private LocalDate externalClinicDate;
    private boolean[] visitable;
    private boolean isExtern;
    //Approximately[]로 약 배열로 줄 약 목록을 추가해도 될듯
    public PetChart(Pet pet, Veterinarian veterinarian, petOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.animalOwner = animalOwner;
        this.enterClinicDate = enterClinicDate;
        this.externalClinicDate = externalClinicDate;
        this.animalId = pet.getId();
        visitable = new boolean[(int) ChronoUnit.DAYS.between(this.getEnterClinicDate(), this.getExternalClinicDate())+1];
        Arrays.fill(visitable, true);
    }
}
