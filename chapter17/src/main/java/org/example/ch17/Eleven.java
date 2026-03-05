package org.example.ch17;

import java.util.Arrays;
import java.util.List;

public class Eleven {
    public void run(){
        List<Student> list = Arrays.asList(
                new Student("hgd",92)
                ,new Student("syg",95)
                ,new Student("kjv",88));
        int sum1 = list.stream().mapToInt(Student::getScore).sum();

        int sum2 = list.stream().map(Student::getScore).reduce(0, (a,b)->a+b);

        System.out.println("sum1:"+sum1);
        System.out.println("sum2:"+sum2);
    }
}
