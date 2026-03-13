package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Odd extends Thread{
    int[] nums;
    @Override
    public void run() {
        System.out.print("odd: ");
        for (int num : nums) {
            if (num % 2 == 1) System.out.print(num + ", ");
        }
        System.out.println();
    }
}
