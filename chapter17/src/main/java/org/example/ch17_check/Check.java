package org.example.ch17_check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Check {
    public void run5(){
        List<String>list= Arrays.asList(
                "This is a java book"
                ,"Ramda Expressions"
                ,"Java8 supports Ramda expressions");
        list.stream().filter(str -> str.toLowerCase().contains("java")).forEach(System.out::println);
    }
    public void run6(){
        List<Member>list= Arrays.asList(
                new Member("hgd","devel",30),
                new Member("syg","design",40),
                new Member("kjv","devel",26)
        );
        double avg = list.stream()
                .mapToInt(Member::getAge)
                .average()
                .orElse(0.0);
        System.out.println("평균 나이: " + avg);
    }
    public void run7(){
        List<Member>list= Arrays.asList(
                new Member("hgd","devel",30),
                new Member("knr","design",26),
                new Member("syg","devel",40)
        );
        List<Member>developers= list.stream()
                .filter(member -> member.getJob().equals("devel"))
                .toList();
        developers.forEach(System.out::println);
    }

    public void run8(){
        List<Member>list= Arrays.asList(
                new Member("hgd","devel",30),
                new Member("knr","design",26),
                new Member("syg","devel",40)
        );
        Map<String,List<Member>> groupingMap = list.stream()
                .collect(Collectors.groupingBy(Member::getJob));
        System.out.println("[개발자]");
        groupingMap.get("devel").forEach(System.out::println);
        System.out.println("[디자이너]");
        groupingMap.get("design").forEach(System.out::println);


    }
}
