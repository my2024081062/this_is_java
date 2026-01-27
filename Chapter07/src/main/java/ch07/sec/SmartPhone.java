package ch07.sec;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmartPhone extends Phone{
    private boolean wifi;

    public SmartPhone(String model, String color) {
        super(model, color);
        System.out.println("SmartPhone(String model, String color) 생성자 실행");
    }

//    public SmartPhone(String model, String color) {
//        super();
//        this.setModel(model);
//        this.setColor(color);
//    }

    public void internet(){
        System.out.println("인터넷에 연결합니다.");
    }
}
