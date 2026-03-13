package org.example.task6;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintGugudan {
    public void printGugudan(){
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("숫자 입력: ");
            Gugudan gugudan = new Gugudan();
            int num;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("읽을수 없는 숫자가 입력되어서 프로그램을 종료함.");
                break;
            }
            gugudan.setNum(num);
            executorService.execute(gugudan);
        }
    }
}
