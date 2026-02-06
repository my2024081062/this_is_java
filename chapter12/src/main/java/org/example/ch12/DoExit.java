package org.example.ch12;

public class DoExit {
    public void doExit(){
        for(int i = 0; i < 10; i++){
            System.out.println(i);
            if(i==5){
                System.out.println("프로세스 강제 종료함");
                System.exit(0);
            }
        }
    }
}
