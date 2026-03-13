package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class Sort extends Thread{
    int[] nums;
    @Override
    public void run() {
        System.out.print("sort: ");
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
