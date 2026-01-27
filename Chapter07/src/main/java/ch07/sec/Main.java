package ch07.sec;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("갤럭시","은색");

        System.out.println("모델: " + myPhone.getModel());
        System.out.println("색상: " + myPhone.getColor());

        System.out.println("와이파이 상태: " + myPhone.isWifi());

        myPhone.bell();
        myPhone.sendVoice("여보세요");
        myPhone.receiveVoice("안녕하세요~");
        myPhone.sendVoice("반갑습니다.~");
        myPhone.handUp();
        myPhone.setWifi(true);


    }
}