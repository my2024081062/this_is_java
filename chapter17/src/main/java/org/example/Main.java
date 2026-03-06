package org.example;

import org.example.ch17.*;
import org.example.ch17_check.Check;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Decimal[] decimal = new Decimal[11];
        decimal[0] = new One();
        decimal[1] = new Two();
        decimal[2] = new Three();
        decimal[3] = new Fore();
        decimal[4] = new Five();
        decimal[5] = new Six();
        decimal[6] = new Seven();
        decimal[7] = new Eight();
        decimal[8] = new Nine();
        decimal[9] = new Ten();
        decimal[10] = new Eleven();
        for (int i = 0; i < decimal.length; i++) {
            System.out.println(i+1 + "번째");
            decimal[i].run();
        }

        Check check = new Check();
        check.run5();
        check.run6();
        check.run7();
        check.run8();


    }
}