package com.mjc813;

public class Calculator {
    void powerOn(){
        System.out.println("전원을 켭니다.");
    }
    void powerOff(){
        System.out.println("전원을 끕니다.");
    }

    int plus(int x, int y){
        return x + y;
    }

    double divide(int x, int y){
        return (double) x/y;
    }

    void sumAll(int ...values){
        int sum = 0;
        for(int value : values){
            sum += value;
        }
        System.out.println("합: " + sum );
    }

    double areaRectangle(double width){
        return width*width;
    }

    double areaRectangle(double width, double height){
        return width*height;
    }
}
