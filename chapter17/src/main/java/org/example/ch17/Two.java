package org.example.ch17;
import java.util.*;
import java.util.stream.Stream;
public class Two extends Decimal{
    public void run(){
        List<String> list = new ArrayList<>();
        list.add("hgd");
        list.add("syg");
        list.add("kjv");
        list.add("rds");
        list.add("pbr");
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach((name) -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        });
        System.out.println();
    }
}
