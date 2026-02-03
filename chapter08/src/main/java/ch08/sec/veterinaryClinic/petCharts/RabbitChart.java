package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class RabbitChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.RABBIT;
    public RabbitChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner, LocalDate enterClinicDate, LocalDate externalClinicDate, EnableAnimal enableAnimal) {
        super(pet, veterinarian, animalOwner, enterClinicDate, externalClinicDate);
    }
}
