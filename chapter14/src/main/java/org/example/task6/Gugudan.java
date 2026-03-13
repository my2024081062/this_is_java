package org.example.task6;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Gugudan implements Runnable {
    private int num;
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getNum() + " * " + i + " = " + getNum()*i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
