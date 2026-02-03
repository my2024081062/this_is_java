package ch08.sec.veterinaryClinic.petCharts;
import ch08.sec.veterinaryClinic.*;

import java.time.LocalDate;

public class CatChart extends PetChart{
    public final EnableAnimal enableAnimal = EnableAnimal.CAT;
    public CatChart(Pet pet, Veterinarian veterinarian, PetOwner animalOwner,Approximately approximately ,LocalDate enterClinicDate, LocalDate externalClinicDate) {
        super(pet, veterinarian, animalOwner, approximately, enterClinicDate, externalClinicDate);
    }
}
