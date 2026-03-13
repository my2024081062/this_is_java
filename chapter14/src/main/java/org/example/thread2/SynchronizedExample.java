package org.example.thread2;

import org.example.Calculator;

public class SynchronizedExample {
    public void synchronizedExample(){
        Calculator calculator = new Calculator();

        User1Thread user1Thread = new User1Thread();
        user1Thread.setCalculator(calculator);

        User2Thread user2Thread = new User2Thread();
        user2Thread.setCalculator(calculator);

        user1Thread.start();
        user2Thread.start();
    }
}
