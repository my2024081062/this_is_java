package ch07.sec.from_eight_to_eleven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Person1 {
    public String name;

    public void walk(){
        System.out.println("걷습니다.");
    }

}
