package com.mjc813;

public class Variable01 {
    static void main(String[] args){
        System.out.println(args.length);
        Variable01 variable01 = new Variable01();
        variable01.howToUseVariable();
    }

    private void howToUseVariable(){
        int value = 0;
        int result = value + 10;
        System.out.println(result);

        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시 " + minute + "분");

        int totalMinute = hour*60 + minute;
        System.out.println("총 " + totalMinute + "분");

        int examX = 3;
        int examY = 5;
        System.out.println("examX: " + examX + ", examY: " + examY);
        
        int temp = examX;
        examX = examY;
        examY = temp;
        System.out.println("examX: " + examX + ", examY: " +examY);
    }
}
