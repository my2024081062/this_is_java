package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class DogChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.DOG;
    public DogChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        super(pet, veterinarian, animalOwner, enterClinicDate, externalClinicDate);
    }
}
