package com.mjc813;

import ch03.sec01.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Chapter03_1 ch03_1 = new Chapter03_1();
        ch03_1.third01();
        ch03_1.third02();
        ch03_1.third03();
        ch03_1.third04();

        Equation eq = new Equation();
        System.out.printf("2x + 4 = 0 의 해 x의 값 : %3.1f\n" , eq.equationFirst(2,4));
        System.out.println("-8x + 40 = 0 의 해 x의 값 : " +eq.equationFirst(-8,40));
        System.out.println("-5x + 32 = 0 의 해 x의 값 : " +eq.equationFirst(-5,32));
        System.out.println("=============================");

        Chapter03_2 ch03_2 = new Chapter03_2();
        ch03_2.third06();
        ch03_2.third07();
        ch03_2.third08();
        ch03_2.third09();
        ch03_2.third10();
        ch03_2.third11();
        ch03_2.third12();
    }
}