package org.example.ch17;
import java.util.*;
import java.util.stream.Stream;
public class Seven {
    public void run(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("hgd",30));
        list.add(new Student("syg",10));
        list.add(new Student("yms",20));
        list.stream()
            .sorted()
            .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        list.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        list.stream()
            .sorted((s1,s2)-> Integer.compare(s1.getScore(), s2.getScore()))
            .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        list.stream()
            .sorted((s1,s2)-> Integer.compare(s2.getScore(), s1.getScore()))
            .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        System.out.println();
    }
}
