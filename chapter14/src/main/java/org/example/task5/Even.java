package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Even extends Thread{
    int[] nums;
    @Override
    public void run() {
        System.out.print("even : ");
        for (int num : nums) {
            if (num % 2 == 0) System.out.print(num + ", ");
        }
        System.out.println();
    }
}
