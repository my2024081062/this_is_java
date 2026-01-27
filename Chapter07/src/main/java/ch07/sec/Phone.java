package ch07.sec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Phone {
    private String model;
    private String color;

    public void bell(){
        System.out.println("벨이 울립니다.");
    }

    public void sendVoice(String message){
        System.out.println("자기 " + message);
    }

    public void receiveVoice(String message){
        System.out.println("상대방 " + message);
    }

    public void handUp(){
        System.out.println("전화를 끊습니다.");
    }
}
