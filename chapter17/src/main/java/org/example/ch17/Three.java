package org.example.ch17;
import java.util.*;
public class Three {
    public void run(){
        List<Student> list = Arrays.asList(
            new Student("hgd",10)
            ,new Student("syg",20)
            ,new Student("kjv",30));

        double avg = list.stream()
            .mapToInt(Student::getScore)
            .average()
            .getAsDouble();

        System.out.println("평균 점수: " + avg);
        System.out.println();
    }
}
