package org.example.thread1;

public class YieldExample {
    public void yieldExample(){
        WorkThread workThreadA = new WorkThread("workThreadA");
        WorkThread workThreadB = new WorkThread("workThreadB");
        workThreadA.start();
        workThreadB.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }
        workThreadA.work = false;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {

        }
        workThreadA.work = true;
    }
}
