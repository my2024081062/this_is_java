package org.example.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ten extends Decimal{
    public void run(){
        int[] intArr =  {1,2,3,4,5};
        long count = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .count();
        System.out.println("2의 배수의 갯수:  " + count);
        long sum = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .sum();
        System.out.println("2의 배수의 합:  " + sum);
        double avg = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .average()
            .getAsDouble();
        System.out.println("2의 배수의 평균:  " + avg);
        int max = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .max()
            .getAsInt();
        System.out.println("2의 배수의 최대값:  " + max);
        int min = Arrays.stream(intArr)
            .filter(n -> n%2==0)
            .min()
            .getAsInt();
        System.out.println("2의 배수의 최소값:  " + min);
        int first = Arrays.stream(intArr)
            .filter(n -> n%3==0)
            .findFirst()
            .getAsInt();
        System.out.println("첫 번째 3의 배수:  " + first);
        System.out.println();

        List<Integer> list = new ArrayList<>();

        try{
            double avg1 = list.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
        }
        catch (Exception e){
            e.getMessage();
        }

        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        if (optionalDouble.isPresent()) {
            System.out.println("방법 1_평균: " + optionalDouble.getAsDouble());
        }
        else{
            System.out.println("방법 1_평균: 0.0");
        }

        double avg1 = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법 2_평균:" + avg1);

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent((a) ->System.out.println("방법 3_평균:" + a));
    }
}
