package org.example.machine;

public class Calculator {
    public long add(int ... items){
        long result = 0L;
        for(int item : items){
            result+=item;
        }
        return result;
    }
}
