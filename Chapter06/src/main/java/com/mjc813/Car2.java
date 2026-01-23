package com.mjc813;

public class Car2 {
    String company;
    String model;
    String color;
    int maxSpeed;

    Car2(String model) {
        this(model, "은색", 250, "현대자동차");
    }

    Car2(String model,String color) {
        this(model, color, 250, "현대자동차");
    }

    Car2(String model, String color, int maxSpeed) {
        this(model, color, maxSpeed, "현대자동차");
    }

    Car2( String model, String color, int maxSpeed,String company) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.company = company;
    }


}
