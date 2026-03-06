package org.example;

import org.example.exam.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Exam[] exam = new Exam[4];
        exam[0] = new Exam2();
        exam[1] = new Exam3();
        exam[2] = new Exam4();
        exam[3] = new Exam6();
        for (int i = 0; i < exam.length; i++) {
            System.out.println(i+1+"번째");
            exam[i].run();
        }
    }
}