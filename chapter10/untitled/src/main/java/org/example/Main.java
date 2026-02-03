package org.example;

import org.example.machine.Calculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        long lVal = cal.add(1,2,3,4,5);
        System.out.println(lVal);
    }
}