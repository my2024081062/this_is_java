package com.mjc813;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Chapter06 ch06_1 = new Chapter06();
//        Chapter06 ch06_2 = new Chapter06("ch06_2");
//
//        ch06_1.runTest();
//        ch06_1.runTest("추가1");
//
//        ch06_2.runTest();
//        ch06_2.runTest("추가2");
//        ch06_2.runTest("추가3", "3");

        Car1 myCar = new Car1();
        Main.readCar1(myCar);

        Korean k1 = new Korean("박자바","010225-1234567");
        Main.readKorean(k1);

        Korean k2 = new Korean("김자바","930525-6543210");
        Main.readKorean(k2);

        Main.readCar2();

        Calculator cal = new Calculator();
        Main.useCal(cal);

        Main.runCar1(myCar);

        Main.areaRectangle(cal);
    }

    public static void readCar1(Car1 car){
        System.out.println("제작회사: " + car.company);
        System.out.println("모델명: " + car.model);
        System.out.println("색깔: " + car.color);
        System.out.println("최고 속도: " + car.maxSpeed);
        System.out.println("현재 속도: " + car.speed);
        System.out.println("출발상태: " + car.start);

        car.speed = 60;
        System.out.println("수정된 속도: " + car.speed);
    }

    public static void readKorean(Korean k){
        System.out.println("k1.nation: " + k.nation);
        System.out.println("k1.name: " + k.name);
        System.out.println("k1.ssn: " + k.ssn);
        System.out.println();
    }

    public static void readCar2(){
        Car2 car2_1 = new Car2("자가용");
        System.out.println("car2_1.company " + car2_1.company);
        System.out.println("car2_1.model: " + car2_1.model);
        System.out.println();

        Car2 car2_2 = new Car2("자가용","빨강");
        System.out.println("car2_2.company " + car2_2.company);
        System.out.println("car2_2.model: " + car2_2.model);
        System.out.println("car2_2.color: " + car2_2.color);
        System.out.println();

        Car2 car2_3 = new Car2("택시", "검정", 200);
        System.out.println("car2_3.company " + car2_3.company);
        System.out.println("car2_3.model: " + car2_3.model);
        System.out.println("car2_3.color: " + car2_3.color);
        System.out.println("car2_3.maxSpeed: " + car2_3.maxSpeed);
        System.out.println();
    }

    public static void useCal(Calculator cal){
        cal.powerOn();

        int result1 = cal.plus(5,6);
        double result2 = cal.divide(10,4);
        System.out.println("result1: " + result1 + "result2: " + result2);
        cal.sumAll(1,2,3);
        cal.sumAll(2,7,9);
        cal.sumAll(1,3,13);
        cal.powerOff();
    }

    public static void runCar1(Car1 myCar){
        myCar.setGas(5);

        if(myCar.isLeftGas()){
            System.out.println("출발합니다.");
            myCar.run();
        }
    }

    public static void areaRectangle(Calculator cal){
        double result1 = cal.areaRectangle(10);
        double result2 = cal.areaRectangle(9,11);

        System.out.println("정사각형 넓이: " +result1);
        System.out.println("직사각형 넓이: " + result2);
    }
}