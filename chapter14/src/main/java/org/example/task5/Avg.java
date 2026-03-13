package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Avg extends Thread{
    int[] nums;
    @Override
    public void run() {
        double avg = 0;
        for (int num : nums) {
            avg += num * 1.0 / nums.length;
        }
        System.out.println("avg: " + avg);
    }
}
