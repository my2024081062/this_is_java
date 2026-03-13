package org.example;

public class GugudanThread extends Thread{
    @Override
    public void run() {
        for (int i = 7; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j  + " = " + i*j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
