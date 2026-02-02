package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnimalOwner {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private String name;
}
