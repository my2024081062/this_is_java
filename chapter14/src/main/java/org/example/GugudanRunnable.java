package org.example;

public class GugudanRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 4; i <= 6; i++) {
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
