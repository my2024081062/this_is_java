package com.mjc813;

import com.mjc813.CheckQuestion.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Chapter06 ch06_1 = new Chapter06();
//        Chapter06 ch06_2 = new Chapter06("ch06_2");
//
//        ch06_1.runTest();
//        ch06_1.runTest("추가1");
//
//        ch06_2.runTest();
//        ch06_2.runTest("추가2");
//        ch06_2.runTest("추가3", "3");

//        Car1 myCar = new Car1();
//        Main.readCar1(myCar);
//
//        Korean k1 = new Korean("박자바","010225-1234567");
//        Main.readKorean(k1);
//
//        Korean k2 = new Korean("김자바","930525-6543210");
//        Main.readKorean(k2);
//
//        Main.readCar2();
//
//        Calculator cal = new Calculator();
//        Main.useCal(cal);
//
//        Main.runCar1(myCar);
//
//        Main.areaRectangle(cal);


//        01-26
//        com.mjc813.sec.Car myCar = new com.mjc813.sec.Car("포르쉐");
//        com.mjc813.sec.Car yourCar = new com.mjc813.sec.Car("벤츠");
//
//        myCar.run(100);
//        yourCar.run(100);
//        Car.simulate();
//
//        double result1 = 10 * 10 * com.mjc813.sec.Calculator.pi;
//        int result2 = com.mjc813.sec.Calculator.plus(10,5);
//        int result3 = com.mjc813.sec.Calculator.minus(10,5);
//
//        System.out.println("result1: " + result1);
//        System.out.println("result2: " + result2);
//        System.out.println("result3: " + result3);
//
//        com.mjc813.sec.Korean k1 = new com.mjc813.sec.Korean("123456-1234567","감자바");
//
//        System.out.println(k1.nation);
//        System.out.println(k1.ssn);
//        System.out.println(k1.name);
//
//        System.out.println("지구의 반지름: " + Earth.EARTH_RADIUS + "km");
//        System.out.println("지구의 반지름: " + Earth.EARTH_SURFACE_AREA + "km^2");
//
//        Car02 newCar  = new Car02();
//
//        newCar.setSpeed(-50);
//        System.out.println("newCar 시속: " +newCar.getSpeed() + "km/h");
//
//        newCar.setSpeed(60);
//        System.out.println("newCar 시속: " +newCar.getSpeed() + "km/h");
//
//        if(!newCar.isStop()){
//            newCar.setStop(true);
//        }
//        System.out.println("newCar 시속: " +newCar.getSpeed() + "km/h");
//        /*
//        Singleton obj1 = new Singleton();
//        Singleton obj2 = new Singleton();
//         */
//        Singleton obj1 = Singleton.getInstance();
//        Singleton obj2 = Singleton.getInstance();
//
//        if(obj1 == obj2){
//            System.out.println("같은 객체입니다 (주소가 같은 유일 객체)");
//        }
//        else{
//            System.out.println("다른 객체입니다 (주소가 다른 여러 객체)");
//        }

        Member user1 = new Member("홍길동","hong");
        MemberService ms = new MemberService();
        boolean result = ms.login("hong","12345");
        if(result){
            System.out.println("로그인 되었습니다.");
             ms.logout("hong");
        }
        else{
            System.out.println("id또는 password가 올바르지 않습니다.");
        }
        Printer p = new Printer();
        p.println(10);
        p.println(true);
        p.println(5.7);
        p.println("홍길동");

        StaticPrinter.println(10);
        StaticPrinter.println(true);
        StaticPrinter.println(5.7);
        StaticPrinter.println("홍길동");

        ShopService obj1 = ShopService.getInstance();
        ShopService obj2 = ShopService.getInstance();

        if(obj1 == obj2){
            System.out.println("같은 객체입니다 (주소가 같은 유일 객체)");
        }
        else{
            System.out.println("다른 객체입니다 (주소가 다른 여러 객체)");
        }

        Account account = new Account();
        account.setBalance(10000);
        System.out.println("현재잔고: " + account.getBalance());

        account();
    }
    public static void account(){
        Scanner scanner = new Scanner(System.in);
        BankApplication ba = new BankApplication();
        while (true){
            System.out.println("-----------------------------------------------");
            System.out.println(" 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료" );
            System.out.println("-----------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if(select == 1){
                System.out.println("-----------");
                System.out.println(" 1.계좌생성" );
                System.out.println("-----------");

                String num,name;
                int bal;

                System.out.print("계좌번호: " );
                num = scanner.nextLine();
                System.out.print("계좌주: " );
                name = scanner.nextLine();
                System.out.print("초기입금액: " );
                bal = scanner.nextInt();

                ba.createAcount(num,name,bal);
            }
            if(select == 2){
                System.out.println("-----------");
                System.out.println(" 2.계좌목록" );
                System.out.println("-----------");
                for (int i = 0; i< 100; i++){
                    if(ba.accounts[i] == null) break;
                    System.out.printf("%s\t%s\t%d\n",ba.accounts[i].getAccountNumber(),ba.accounts[i].getAccountName(),ba.accounts[i].getBalance());
                }
            }
            if(select == 3){
                System.out.println("-----------");
                System.out.println(" 3.예금" );
                System.out.println("-----------");

                String num;
                int bal;
                System.out.print("계좌번호: " );
                num = scanner.nextLine();
                System.out.print("예금액: " );
                bal = scanner.nextInt();
                for (int i = 0; i< 100; i++){
                    if(ba.accounts[i] == null) {
                        System.out.println("계좌를 찾지 못했습니다." );
                        break;
                    }
                    if(ba.accounts[i].equals(num)){
                        ba.accounts[i].setBalance(num,bal);
                    }
                }
            }
            if(select == 4){
                System.out.println("-----------");
                System.out.println(" 4.출금" );
                System.out.println("-----------");

                String num;
                int bal;
                System.out.print("계좌번호: " );
                num = scanner.nextLine();
                System.out.print("출금액: " );
                bal = scanner.nextInt();
                for (int i = 0; i< 100; i++){
                    if(ba.accounts[i] == null) {
                        System.out.println("계좌를 찾지 못했습니다." );
                        break;
                    }
                    if(ba.accounts[i].equals(num)){
                        if(ba.accounts[i].getBalance() - bal >= 0) {
                            ba.accounts[i].setBalance(num, -bal);
                            System.out.println("결과: 출금이 성공하였습니다.");
                        }
                        else{
                            System.out.println("결과: 출금하지 못하였습니다.");
                        }
                    }
                }
            }
            if(select == 5){
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
//    public static void readCar1(Car1 car){
//        System.out.println("제작회사: " + car.company);
//        System.out.println("모델명: " + car.model);
//        System.out.println("색깔: " + car.color);
//        System.out.println("최고 속도: " + car.maxSpeed);
//        System.out.println("현재 속도: " + car.speed);
//        System.out.println("출발상태: " + car.start);
//
//        car.speed = 60;
//        System.out.println("수정된 속도: " + car.speed);
//    }
//
//    public static void readKorean(Korean k){
//        System.out.println("k1.nation: " + k.nation);
//        System.out.println("k1.name: " + k.name);
//        System.out.println("k1.ssn: " + k.ssn);
//        System.out.println();
//    }
//
//    public static void readCar2(){
//        Car2 car2_1 = new Car2("자가용");
//        System.out.println("car2_1.company " + car2_1.company);
//        System.out.println("car2_1.model: " + car2_1.model);
//        System.out.println();
//
//        Car2 car2_2 = new Car2("자가용","빨강");
//        System.out.println("car2_2.company " + car2_2.company);
//        System.out.println("car2_2.model: " + car2_2.model);
//        System.out.println("car2_2.color: " + car2_2.color);
//        System.out.println();
//
//        Car2 car2_3 = new Car2("택시", "검정", 200);
//        System.out.println("car2_3.company " + car2_3.company);
//        System.out.println("car2_3.model: " + car2_3.model);
//        System.out.println("car2_3.color: " + car2_3.color);
//        System.out.println("car2_3.maxSpeed: " + car2_3.maxSpeed);
//        System.out.println();
//    }
//
//    public static void useCal(Calculator cal){
//        cal.powerOn();
//
//        int result1 = cal.plus(5,6);
//        double result2 = cal.divide(10,4);
//        System.out.println("result1: " + result1 + "result2: " + result2);
//        cal.sumAll(1,2,3);
//        cal.sumAll(2,7,9);
//        cal.sumAll(1,3,13);
//        cal.powerOff();
//    }
//
//    public static void runCar1(Car1 myCar){
//        myCar.setGas(5);
//
//        if(myCar.isLeftGas()){
//            System.out.println("출발합니다.");
//            myCar.run();
//        }
//    }
//
//    public static void areaRectangle(Calculator cal){
//        double result1 = cal.areaRectangle(10);
//        double result2 = cal.areaRectangle(9,11);
//
//        System.out.println("정사각형 넓이: " +result1);
//        System.out.println("직사각형 넓이: " + result2);
//    }

}