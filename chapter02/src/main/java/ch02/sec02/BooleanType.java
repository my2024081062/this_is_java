package ch02.sec02;

public class BooleanType {
    public void useBoolean(){
        boolean stop = true;
        if(stop){
            System.out.println("중지합니다.");
        }
        else {
            System.out.println("시작합니다.");
        }

        byte x = 10;
        boolean result1 = (x==20);
        boolean result2 = (x!=20);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
    }
}
