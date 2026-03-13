package org.example.thread1;

public class JoinExample {
    public void joinExample(){
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException ignore) {
        }
        System.out.println("합: " + sumThread.getSum());
    }
}
