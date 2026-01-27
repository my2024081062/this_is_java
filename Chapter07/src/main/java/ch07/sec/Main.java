package ch07.sec;
import ch07.sec.inheritances.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        SmartPhone myPhone = new SmartPhone("갤럭시","은색");
//
//        System.out.println("모델: " + myPhone.getModel());
//        System.out.println("색상: " + myPhone.getColor());
//
//        System.out.println("와이파이 상태: " + myPhone.isWifi());
//
//        myPhone.bell();
//        myPhone.sendVoice("여보세요");
//        myPhone.receiveVoice("안녕하세요~");
//        myPhone.sendVoice("반갑습니다.~");
//        myPhone.handUp();
//        myPhone.setWifi(true);
//        myPhone.internet();
//
//        303~311
        Two two = new Two();
        Three three = new Three();
        Four four = new Four();
        Five five = new Five();

        One one1 = two;
        One one2 = three;
        One one3 = four;
        One one4 = five;

        Two two1 = four;
        Three three1 = five;

//        Two two2 = five;
//        Three three2 = four;

        Child child = new Child();

        Parent parent = child;

        parent.method1();
        parent.method2();
//        parent.method3();
//        자식 -> 부모으로 했기 때문에 자식의 메소드는 못씀.
//        Parent p = new Parent();
//        Child c = (Child) p; 부모 -> 자식은 형변환이 안됨.
//        c.method1();
//        c.method2();
//        c.method3();
    }
}