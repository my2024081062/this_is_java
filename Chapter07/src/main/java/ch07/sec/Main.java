package ch07.sec;
import ch07.sec.sugang.*;

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
//        Two two = new Two();
//        Three three = new Three();
//        Four four = new Four();
//        Five five = new Five();
//
//        One one1 = two;
//        One one2 = three;
//        One one3 = four;
//        One one4 = five;
//
//        Two two1 = four;
//        Three three1 = five;
//
////        Two two2 = five;
////        Three three2 = four;
//
//        Child child = new Child();
//
//        Parent parent = child;
//
//        parent.method1();
//        parent.method2();
//        parent.method3();
//        자식 -> 부모으로 했기 때문에 자식의 메소드는 못씀.
//        Parent p = new Parent();
//        Child c = (Child) p; 부모 -> 자식은 형변환이 안됨.
//        c.method1();
//        c.method2();
//        c.method3();


//    학생이 강의를 수강해서 성적을 받는 생활을 클래스 설계 해보세요.
//    클래스는 학생, 강의과목, 학생이 과목을 수강 하고 성적을 받는 과정의
//    데이터가 잘 저장되고 표현 되도록 설계 해보세요.
//    정답은 없으므로 여러분의 경험에 기반하여 클래스를 만들어 봅니다.
//    속성과 동작을 잘 구분하여 만들고 Lombok 을 활용 합니다.
//    클래스 이름 속성, 동작 이름은 자유롭습니다.
//    설계한 소스는 개인과제 git 리포지토리에 올립니다.
//    기한은 약 1~3시간 정도 개발할 양이면 됩니다. 너무 적어도 많아도 안됩니다.

        Professor p1 = new Professor(101,"최","컴공");
        Student s1 = new Student(204,"이","컴공");
        Student s2 = new Student(205,"박","컴공");
        Subject sb1 = new Subject("DB",3,"컴공");
        Subject sb2 = new Subject("Java 기초",3,"컴공");
        Subject sb3 = new Subject("Java 활용",3,"컴공");
        DB db = DB.getInstance();

        s1.listen(sb1,p1);
        s2.listen(sb1,p1);
        s1.listen(sb2,p1);
        s2.listen(sb2,p1);
        s1.listen(sb3,p1);
        s2.listen(sb3,p1);

        db.showAllGrade();
        db.showOneGrade(s2);
    }
}