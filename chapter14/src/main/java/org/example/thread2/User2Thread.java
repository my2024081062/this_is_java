package org.example.thread2;

import lombok.Setter;
import org.example.Calculator;

@Setter
public class User2Thread extends Thread{
    private Calculator calculator;

    public User2Thread(){
        setName("User2Thread");
    }

    @Override
    public void run() {
        calculator.setMemory2(50);
    }
}
