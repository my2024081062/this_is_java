package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
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
    private final int animalId = animal.getId();
    private Veterinarian veterinarian;
    private AnimalOwner animalOwner;
    private LocalDate enterClinicDate;
    private LocalDate externalClinicDate;
    private final boolean[] visitable = new boolean[(int) ChronoUnit.DAYS.between(this.getEnterClinicDate(), this.getExternalClinicDate())+1];

    public AnimalChart(Animal animal, Veterinarian veterinarian, AnimalOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        this.animal = animal;
        this.veterinarian = veterinarian;
        this.animalOwner = animalOwner;
        this.enterClinicDate = enterClinicDate;
        this.externalClinicDate = externalClinicDate;
        Arrays.fill(visitable, true);
    }

    public static int getAnimalChart_id(){
        return AnimalChart.animalChart_id;
    }
}
