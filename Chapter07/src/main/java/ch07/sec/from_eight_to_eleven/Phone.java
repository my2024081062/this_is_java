package ch07.sec.from_eight_to_eleven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Phone {
    String owner;

    public void turnOn(){
        System.out.println("폰 전원을 켭니다" );
    }
    public void turnOff(){
        System.out.println("폰 전원을 끕니다" );
    }
}
