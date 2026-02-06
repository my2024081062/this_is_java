package org.example.ch12;

public class ErrAndIn {
    public void doErr(){
        try {
            int a = Integer.parseInt("1o0");
            System.out.println(a);
        }
        catch (NumberFormatException nfe){
            System.err.println("에러 내용: " + nfe.getMessage());
        }
    }

    public void doIn() throws Exception{
        int speed = 0;
        int keyCode = 0;

        while (true){
            if(keyCode != 13 && keyCode != 10){
                if(keyCode == 49){
                    speed+=1;
                }
                else if(keyCode == 50){
                    speed-=1;
                }
                else if(keyCode == 51){
                    break;
                }
                System.out.println("-------------------");
                System.out.println("1. 증속 | 2. 감속 | 3. 종료");
                System.out.println("-------------------");
                System.out.println("현재 속도: " + speed);
                System.out.print("선택: ");
            }
            keyCode = System.in.read();
        }
        System.out.println("프로그램 종료");
    }
}
