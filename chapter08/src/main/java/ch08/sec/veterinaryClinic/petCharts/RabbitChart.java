package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class RabbitChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.RABBIT;

    public RabbitChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner, Approximately approximately, LocalDate enterClinicDate, LocalDate externalClinicDate) {
        super(pet, veterinarian, animalOwner, approximately, enterClinicDate, externalClinicDate);
    }
}
