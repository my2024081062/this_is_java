package org.example.ch17;
import java.util.*;
public class Eight extends Decimal{
    public void run(){
        int[] intArr =  {1,2,3,4,5};
        Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .peek(System.out::println);
        int total = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .peek(System.out::println)
            .sum();
        System.out.println("총합: " + total);
        System.out.println();

        Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .forEach(System.out::println);
    }
}
