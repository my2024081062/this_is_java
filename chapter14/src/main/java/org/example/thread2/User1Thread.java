package org.example.thread2;

import lombok.Setter;
import org.example.Calculator;

@Setter
public class User1Thread extends Thread{
    private Calculator calculator;

    public User1Thread(){
        setName("User1Thread");
    }

    @Override
    public void run() {
        calculator.setMemory1(100);
    }
}
