package org.example;

import org.example.exam.Exam1;
import org.example.exam.Human;
import org.example.exam.Packaging;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Exam1 exam1 = new Exam1();
        exam1.exam1();

        Packaging<Human> humanPackaging = new Packaging<>();
        humanPackaging.add(new Human("lsh",24));
        humanPackaging.add(new Human("csk",23));
        humanPackaging.add(new Human("psk",24));

        Human human = humanPackaging.remove();
        System.out.println(human.getName());

        Packaging<String> stringPackaging = new Packaging<>();
        stringPackaging.add("abc");
        stringPackaging.add("def");
        String s = stringPackaging.remove();
        System.out.println(s);
    }
}