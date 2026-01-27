package ch07.sec;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    public int speed;

    public void speedUp(){
        this.setSpeed(getSpeed()+1);
    }

    public final void stop(){
        System.out.println("차를 멈춤");
        this.setSpeed(0);
    }
}
