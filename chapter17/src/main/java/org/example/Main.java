package org.example;

import org.example.ch17.*;
import org.example.ch17_check.Check;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Check check = new Check();
        check.run5();
        check.run6();
        check.run7();
        check.run8();

    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        LinkedList<Integer> realLost = Arrays.stream(lost)
                .filter(value -> !Arrays.stream(reserve)
                        .boxed()
                        .collect(Collectors.toSet())
                        .contains(value))
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        int[] realReserve = Arrays.stream(reserve)
                .filter(value -> !Arrays.stream(lost)
                        .boxed()
                        .collect(Collectors.toSet())
                        .contains(value))
                .toArray();
        if(){

        }
        else if(){

        }
        else {
            for(int i = 0; i < realLost.length-1;i++){
                for(int j = 0; j < realReserve.length-1;j++){
                    if(realLost[i]+1 == realReserve[j] && realLost[i+1]-1 == realReserve[j]){

                    }
                }
            }
        }
        return answer;
    }
}