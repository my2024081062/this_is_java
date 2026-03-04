package org.example.ch17;
import java.util.*;
import java.util.stream.Stream;
public class Five {
    public void run(){
        List<String> list = new ArrayList<>();
        list.add("hgd");
        list.add("syg");
        list.add("kjv");
        list.add("syg");
        list.add("smc");

        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        list.stream().filter(n -> n.startsWith("s")).forEach(System.out::println);
        System.out.println();
        list.stream().distinct().filter(n -> n.startsWith("s")).forEach(System.out::println);
        System.out.println();
    }
}
