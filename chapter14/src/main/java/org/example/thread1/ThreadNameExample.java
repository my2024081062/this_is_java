package org.example.thread1;

public class ThreadNameExample {
    public void threadNameExample(){
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread(){
                @Override
                public void run() {
                    System.out.println(getName() + " 실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread(){
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }
}
