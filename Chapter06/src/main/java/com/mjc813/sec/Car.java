package com.mjc813.sec;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    String model;
    int speed;

    public Car(String model){
        this.model = model;
    }

    public void run(int speed){
        this.setSpeed(speed);
        System.out.println(this.model + "가 달립니다.(시속: " +this.speed + "km/h)");
    }

    public static void simulate(){
        Car car = new Car("simulatedCar");
        car.setSpeed(200);
        car.run(car.getSpeed());
    }
}
