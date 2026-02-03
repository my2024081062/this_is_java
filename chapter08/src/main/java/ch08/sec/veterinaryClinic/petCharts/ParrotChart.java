package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class ParrotChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.PARROT;
    public ParrotChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate, EnableAnimal enableAnimal) {
        super(pet, veterinarian, animalOwner, enterClinicDate, externalClinicDate);
    }
}
