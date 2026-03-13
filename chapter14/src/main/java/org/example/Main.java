package org.example;

import org.example.task5.Input;
import org.example.task6.PrintGugudan;
import org.example.thread1.*;
import org.example.thread2.*;

public class Main {
    public static void main(String[] args) {
//        doThread1();
//        // 1
//        gugudan(2,9,100);
//        // 2
//        gugudan(2,4,50);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                gugudan(5,9,50);
//            }
//        });
//        thread1.start();
//        //3
//        GugudanThread gugudanThread = new GugudanThread();
//        GugudanRunnable gugudanRunnable = new GugudanRunnable();
//
//        gugudan(2,3,50);
//        gugudanRunnable.run();
//        gugudanThread.start();
//        //4
//        PrintOneLetter printOneLetter = PrintOneLetter.getPrintOneLetter();
//        InputOneLetter inputOneLetter = new InputOneLetter();
//        inputOneLetter.start();
//        printOneLetter.start();
//        //5
//        Input input = new Input();
//        input.input();
//        //6
//        PrintGugudan printGugudan = new PrintGugudan();
//        printGugudan.printGugudan();
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        solution.solution(nums,"left");
    }

    private static void doThread1(){
        BeepPrintExample beepPrintExample = new BeepPrintExample();
        beepPrintExample.beepPrintExample();

        ThreadNameExample threadNameExample = new ThreadNameExample();
        threadNameExample.threadNameExample();

        JoinExample joinExample = new JoinExample();
        joinExample.joinExample();

        YieldExample yieldExample = new YieldExample();
        yieldExample.yieldExample();
    }

    private static void gugudan(int start, int end, int sleep){
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j  + " = " + i*j);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
    private static void doThread2(){
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        synchronizedExample.synchronizedExample();
    }
}