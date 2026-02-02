package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Calendar;
@Getter
@AllArgsConstructor
public class Veterinarian {
    private static int veterinarian_id = 0;
    private final int id = veterinarian_id++;
    private String name;

    public void AnimalCare(Animal animal){
        System.out.println(animal.getName() + "을(를) 진료합니다.");

    }
}
