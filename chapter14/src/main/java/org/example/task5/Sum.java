package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sum extends Thread{
    int[] nums;
    @Override
    public void run() {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("sum: " + sum);
    }
}
