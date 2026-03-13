package org.example;

import org.example.thread1.*;

public class Main {
    public static void main(String[] args) {
//        doThread1();
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
}