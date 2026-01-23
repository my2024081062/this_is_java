package com.mjc813;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Chapter06 ch06_1 = new Chapter06();
        Chapter06 ch06_2 = new Chapter06("ch06_2");

        ch06_1.runTest();
        ch06_1.runTest("추가1");

        ch06_2.runTest();
        ch06_2.runTest("추가2");
        ch06_2.runTest("추가3", "3");
    }
}