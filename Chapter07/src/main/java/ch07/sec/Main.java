package ch07.sec;
import ch07.sec.from_eight_to_eleven.*;
import ch07.sec.from_eight_to_eleven.SmartPhone;
import ch07.sec.inheritance.*;
import ch07.sec.polym.*;

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
//        Child1 child = new Child1();
//
//        Parent1 parent = child;
//
//        parent.method1();
//        parent.method2();
//        parent.method3();
//        자식 -> 부모으로 했기 때문에 자식의 메소드는 못씀.
//        Parent1 p = new Parent1();
//        Child1 c = (Child1) p; 부모 -> 자식은 형변환이 안됨.
//        c.method1();
//        c.method2();
//        c.method3();

        SamsungTV sss = new SamsungTV("T50US", "20AS92GEKS0KEOS", 14.1, 1998);
        System.out.println(sss.getInfo());

        Television ttt = sss;
        SamsungTV ss2 = (SamsungTV) ttt;
        System.out.println(ss2.getInfo());

        Television t1 = new Television();
//		SamsungTV ss3 = (SamsungTV)t1;  // 부모객체는 자식클래스로 타입캐스팅 안된다.
//		System.out.println(ss3.getInfo());

        sss.print(ss2); // ss2 의 데이터형은 SamsungTv, Television, Object 3가지 형태로 변환이 가능하다.
        sss.printAll(t1);
        sss.printAll(ss2);
        sss.printAll("object");

        Child child1 = new Child(10, "홍길동", 90, 7);
        Parent parent1 = child1;
        Child child2 = null;
        if ( parent1 instanceof Child ) {
            child2 = (Child)parent1;
        }
        Parent child3 = new Child(170, 70);
        System.out.println(child1.toString());
        System.out.println(parent1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

        Parent parent2 = new Parent( 37, "홍순자" );
        System.out.println(parent2.toString());
        Child child4 = null;
        if ( parent2 instanceof Child ) {
            child4 = (Child)parent2;
        }
        System.out.println(child4 == null ? "" : child4.toString());

        LifeOfHuman[] arrayHumans = new LifeOfHuman[10];
        arrayHumans[0] = new LifeOfHuman( new Human("최치원") );
        arrayHumans[0].liveHuman();
        arrayHumans[1] = new LifeOfHuman( new Man("최원철", "큰목젓") );
        arrayHumans[1].liveHuman();
        LifeOfHuman loh3 = new LifeOfHuman( new Woman("이나현", "부드러운피부") );
        loh3.liveHuman();
        LifeOfHuman loh4 = new LifeOfHuman( new Children("복덩이", "키:90, 몸무게:11") );
        loh4.liveHuman();
        LifeOfHuman loh5 = new LifeOfHuman( new ChildStudent("복순이", "키:90, 몸무게:11", "해바라기반") );
        loh5.liveHuman();

        loh5.whoFamily(arrayHumans[0].getHuman(), loh3.getHuman());

        Human h1 = loh5.getMyself();
        if ( h1 instanceof Man ) {
            Man m1 = (Man) h1;
            System.out.println(m1.toString());
            // m1.기능(); Man 데이터형이어야 한다.
        }
        if ( h1 instanceof ChildStudent cs1 ) {
//			ChildStudent cs1 = (ChildStudent) h1;
            System.out.println(cs1.toString());
            // cs1.기능(); ChildStudent 데이터형이어야 한다.
        }
        if ( h1 instanceof Children c1 ) {
//			Children c1 = (Children)h1;
            System.out.println(c1.toString());
            // c1.기능(); Children 데이터형이어야 한다.
        }

//    학생이 강의를 수강해서 성적을 받는 생활을 클래스 설계 해보세요.
//    클래스는 학생, 강의과목, 학생이 과목을 수강 하고 성적을 받는 과정의
//    데이터가 잘 저장되고 표현 되도록 설계 해보세요.
//    정답은 없으므로 여러분의 경험에 기반하여 클래스를 만들어 봅니다.
//    속성과 동작을 잘 구분하여 만들고 Lombok 을 활용 합니다.
//    클래스 이름 속성, 동작 이름은 자유롭습니다.
//    설계한 소스는 개인과제 git 리포지토리에 올립니다.
//    기한은 약 1~3시간 정도 개발할 양이면 됩니다. 너무 적어도 많아도 안됩니다.

//        Professor p1 = new Professor(101,"최","컴공");
//        Student s1 = new Student(204,"이","컴공");
//        Student s2 = new Student(205,"박","컴공");
//        Subject sb1 = new Subject("DB",3,"컴공");
//        Subject sb2 = new Subject("Java 기초",3,"컴공");
//        Subject sb3 = new Subject("Java 활용",3,"컴공");
//        DB db = DB.getInstance();
//
//        s1.listen(sb1,p1);
//        s2.listen(sb1,p1);
//        s1.listen(sb2,p1);
//        s2.listen(sb2,p1);
//        s1.listen(sb3,p1);
//        s2.listen(sb3,p1);
//
//        db.showAllGrade();
//        db.showOneGrade(s2);
        ch07.sec.from_eight_to_eleven.Car mCar = new ch07.sec.from_eight_to_eleven.Car();
        mCar.setTire(new Tire());
        mCar.run();
        mCar.run();
        mCar.setTire(new H_Tire());
        mCar.run();
        mCar.setTire(new K_Tire());

        ch07.sec.from_eight_to_eleven.Driver d = new ch07.sec.from_eight_to_eleven.Driver();
        d.drive(new Bus());
        d.drive(new Taxi());

        Person1 p1 = new Person1("홍");
        InstanceofExample.info(p1);

        System.out.println();

        Person1 p2 = new Student1("김",123);
        InstanceofExample.info(p2);

//        Phone phone = new Phone();
        SmartPhone phone = new SmartPhone("홍");
        phone.turnOn();
        phone.internetSearch();
        phone.turnOff();

        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        Main.animalSound(new Dog());
        Main.animalSound(new Cat());

        Person2 p3 = new Person2();
        Employee e1 = new Employee();
        Manager m1 = new Manager();
        Director d1 = new Director();

        p3.work();
        e1.work();
        m1.work();
        d1.work();

    }

    public static void animalSound(Animal a){
        a.sound();
    }
}