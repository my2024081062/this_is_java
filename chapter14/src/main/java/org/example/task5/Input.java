package org.example.task5;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public void input(){
        Scanner s = new Scanner(System.in);
        int[] nums = Arrays.stream(s.next().split(",")).mapToInt(Integer::parseInt).toArray();

        Thread[] threads = new Thread[5];
        threads[0] = new Sum(nums);
        threads[1] = new Avg(nums);
        threads[2] = new Sort(nums);
        threads[3] = new Odd(nums);
        threads[4] = new Even(nums);
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
