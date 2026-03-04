package org.example.ch17;

import java.util.Arrays;

public class Nine {
    public void run(){
        int[] intArr =  {2,4,6};
        boolean result = Arrays.stream(intArr)
                .allMatch(n -> n%2==0);
        System.out.println("모두 2의 배수 인가?  " + result);
        result = Arrays.stream(intArr)
            .anyMatch(n -> n%3==0);
        System.out.println("하나라도 3의 배수 인가?  " + result);
        result = Arrays.stream(intArr)
            .noneMatch(n -> n%3==0);
        System.out.println("하나라도 3의 배수가 아닌가?  " + result);
    }
}
