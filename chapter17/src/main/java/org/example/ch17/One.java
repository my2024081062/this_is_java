package org.example.ch17;

import java.util.*;
import java.util.stream.Stream;

public class One extends Decimal {
    public void run(){
        Set<String> set = new HashSet<>();
        set.add("hgd");
        set.add("syg");
        set.add("kjv");
        Stream<String> stream = set.stream();
        stream.forEach((name) -> System.out.println(name));
        System.out.println();
    }
}
