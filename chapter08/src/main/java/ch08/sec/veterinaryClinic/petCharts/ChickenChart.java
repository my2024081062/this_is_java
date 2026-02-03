package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class ChickenChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.CHICKEN;

    public ChickenChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner, Approximately approximately, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        super(pet, veterinarian, animalOwner, approximately, enterClinicDate, externalClinicDate);
    }
}
