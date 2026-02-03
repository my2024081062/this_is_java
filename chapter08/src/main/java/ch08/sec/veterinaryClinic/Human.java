package ch08.sec.veterinaryClinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Human implements Animal{
    private String name;

    @Override
    public void sound(){
        System.out.println("아아");
    }
}
