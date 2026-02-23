package org.example.aNewCh12;

import java.util.Arrays;
import java.util.Random;

public class UseMath {
    public void math(){
        double v1 = Math.ceil(5.3);
        double v2 = Math.floor(5.3);

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        long v3 = Math.max(3,7);
        long v4 = Math.min(3,7);

        System.out.println("v3 = " + v3);
        System.out.println("v4 = " + v4);

        double value = 12.3456;
        double tmp1 = value * 100;
        long tmp2 = Math.round(tmp1);

        double v5 = tmp2/ 100.0;
        System.out.println("v5 = " + v5);
        System.out.println("--------------------------");
    }

    public void random(){
        int[] selectNumber = new int[6];
        Random random = new Random(3);

        System.out.print("선택 번호 : ");
        for(int i = 0; i<selectNumber.length; i++){
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.println(selectNumber[i] + " ");
        }
        System.out.println();

        int[] winningNumber = new int[6];
        random = new Random(5);

        System.out.print("당첨 번호 : ");
        for(int i = 0; i<winningNumber.length; i++){
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.println(winningNumber[i] + " ");
        }
        System.out.println();

        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);

        boolean result = Arrays.equals(selectNumber,winningNumber);

        System.out.println("당첨 여부 : " + ((result) ? "당첨되었습니다." : "당첨되지 않았습니다."));
        System.out.println("--------------------------");
    }
}
