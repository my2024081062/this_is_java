package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Animal {
    private static int animal_id = 0;
    private final int id = animal_id++;
    private String name;
    private EnableAnimal enableAnimal;
    private boolean careNeed;


}
