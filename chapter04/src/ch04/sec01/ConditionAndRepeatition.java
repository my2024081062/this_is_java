package ch04.sec01;

import java.util.Scanner;

public class ConditionAndRepeatition {
    public void doConditonAndRepeatition() {
        String grade = "B";

        int result1 = switch (grade){
            case "A" -> 100;
            case "B" -> {
                int val = 100 - 20;
                yield val;
            }
            default -> 60;
        };
        System.out.println("result1 = " + result1);
        System.out.println("===========================================");

        int result2 = 0;
        for (int i = 1; i <= 100; i++) {
            result2 += threeNumber(i);
        }
        System.out.println("result2 = " + result2);

        int result3 = 0;
        int i = 1;
        while (i <= 100) {
            result3 += threeNumber(i);
            i++;
        }
        System.out.println("result3 = " + result3);

        int result4 = 0;
        i = 1;
        do {
            result4 += threeNumber(i);
            i++;
        } while (i <= 100);

        System.out.println("result4 = " + result4);
        System.out.println("===========================================");

        while (true){
            if (diceSumIsFive() )break;
        }
        System.out.println("===========================================");
        for (;;) {
            if (diceSumIsFive() )break;
        }
        System.out.println("===========================================");
        do {
            if (diceSumIsFive() )break;
        } while (true);
        System.out.println("===========================================");

        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                if(x * 4 + y * 5 == 60){
                    System.out.printf("10이하의 자연수 중 4x + 5y = 60의 해 x, y는 (%d , %d) \n", x, y);
                }
            }
        }
        System.out.println("===========================================");
        int x = 0;
        while (x<=10){
            int y = 0;
            while (y<=10){
                if(x * 4 + y * 5 == 60){
                    System.out.printf("10이하의 자연수 중 4x + 5y = 60의 해 x, y는 (%d , %d) \n", x, y);
                }
                y++;
            }
            x++;
        }
        System.out.println("===========================================");
        x = 0;
        do {
            int y = 0;
            do {
                if(x * 4 + y * 5 == 60){
                    System.out.printf("10이하의 자연수 중 4x + 5y = 60의 해 x, y는 (%d , %d) \n", x, y);
                }
                y++;
            } while (y<=10);
            x++;
        } while (x<=10);
        System.out.println("===========================================");

        for (i = 1; i <= 5; i++){
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("===========================================");

        i = 1;
        while (i <= 5){
            int j = 0;
            while (5-j > i){
                System.out.print(" ");
                j++;
            }
            int k = 0;
            while (k < i){
                System.out.print("*");
                k++;
            }
            System.out.println();
            i++;
        }
        System.out.println("===========================================");
        i = 1 ;
        do{
            int j = 0;
            do{
                System.out.print(" ");
                j++;
            } while (j < (5-i));
            int k = 0;
            do{
                System.out.print("*");
                k++;
            } while (k < i*2-1);
            i++;
            do {
                System.out.print(" ");
                j--;
            } while (j >= 0);
            System.out.println();
        } while (i <= 5);
        System.out.println("===========================================");

        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        while (true){
            System.out.println("-----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("-----------------------------------");
            int num = scanner.nextInt();
            if(num == 1){
                System.out.println("선택> " +  num);
                int money = scanner.nextInt();
                amount += money;
                System.out.println("예금액 : " + money);
            }
            if(num == 2){
                System.out.println("선택> " +  num);
                int money = scanner.nextInt();
                amount -= money;
                System.out.println("출금액 : " + money);
            }
            if(num == 3){
                System.out.println("선택> " +  num);
                System.out.println("잔고 : " + amount);
            }
            if(num == 4){
                System.out.println("선택> " +  num);
                break;
            }
        }
        System.out.println("프로그램 종료");
    }

    private int threeNumber(int num) {
        return num%3==0 ? num : 0;
    }
    private boolean diceSumIsFive() {
        int r1 = (int) (Math.random()*5)+1;
        int r2 = (int) (Math.random()*5)+1;
        System.out.printf("주사위 2개의 결과 : (%d, %d)\n", r1, r2);
        return r1 + r2 == 5;
    }
}
