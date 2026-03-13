package org.example.thread1;

import java.awt.*;

public class SleepExample {
    public void sleepExample(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {

            }
        }
    }
}
