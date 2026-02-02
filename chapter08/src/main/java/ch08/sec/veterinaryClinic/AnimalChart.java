package ch08.sec.veterinaryClinic;

public class AnimalChart {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private Animal animal;
    private Nurse nurse;
    private AnimalOwner animalOwner;
}
