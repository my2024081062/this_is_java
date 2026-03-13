package org.example;

import lombok.Getter;

@Getter
public class Calculator {
    private int memory;

    public synchronized void setMemory1(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignore) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }

    public void setMemory2(int memory) {
        synchronized (this){
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignore) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
