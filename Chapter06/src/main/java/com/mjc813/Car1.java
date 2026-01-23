package com.mjc813;

public class Car1 {
    String company = "현대자동차";
    String model = "그랜저";
    String color = "검정";
    int speed = 0;
    int maxSpeed = 350;
    boolean start = false;
    Tire tire = new Tire();
    int gas = 0;

    Car1(String company, String model, String color, int speed, int maxSpeed, Tire tire){
    }
    Car1(){
        this(null,null,null,0,0,new Tire());
    }

    void setGas(int gas){
        this.gas = gas;
    }

    boolean isLeftGas(){
        if(this.gas == 0){
            System.out.println("가스가 없습니다. ");
            return false;
        }
        System.out.println("가스가 있습니다. ");
        return true;
    }

    void run(){
        while (true){
            if(gas > 0){
                System.out.println("달립니다.(gas 잔량: " + this.gas-- +")");
            }
            else {
                System.out.println("멈춥니다.(gas 잔량: " + this.gas +")");
                System.out.println("gas를 주입하세요.");
                return;
            }
        }
    }
}
