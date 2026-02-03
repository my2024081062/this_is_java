package ch08.sec.veterinaryClinic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Getter
@Setter
public class PetChart {
    private static int animalChart_id = 0;
    private final int id = animalChart_id++;
    private Pet pet;
    private Veterinarian veterinarian;
    private PetOwner animalOwner;
    private Approximately approximately;
    private LocalDate enterClinicDate;
    private LocalDate externalClinicDate;
    private boolean[] visitable;
    private boolean isExtern;
    private LocalTime eatFoodTime;
    private int eatFoodAmount;

    public PetChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner,Approximately approximately,
                    LocalDate enterClinicDate, LocalDate externalClinicDate,LocalTime eatFoodTime,int eatFoodAmount) {
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.animalOwner = animalOwner;
        this.approximately = approximately;
        this.enterClinicDate = enterClinicDate;
        this.externalClinicDate = externalClinicDate;
        visitable = new boolean[(int) ChronoUnit.DAYS.between(this.getEnterClinicDate(), this.getExternalClinicDate())+1];
        Arrays.fill(visitable, true);
    }
}
