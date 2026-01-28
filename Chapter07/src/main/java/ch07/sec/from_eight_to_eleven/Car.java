package ch07.sec.from_eight_to_eleven;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    public Tire tire;

    public void run(){
        this.getTire().roll();
    }
}
