package com.mjc813;
import java.util.*;
public class Task03 {
    public void one(){
        double dArray[] = new double[25];
        for (int i = 0; i< dArray.length; i++){
            dArray[i] = Math.random()*100;
        }
        int nArray[] = new int[25];
        int sum = 0;
        for (int i = 0; i< nArray.length; i++){
            nArray[i] = (int) (Math.random()*100);
            sum += nArray[i];
        }
        System.out.println("전체 원소들의 합 : " +  sum);
        System.out.println("전체 원소들의 평균 : " +  sum/25);

        String[] strArray = new String[25];
        for (int i = 0; i< strArray.length; i++){
            strArray[i] = dArray[i] + " => " + (int) dArray[i];
            System.out.print(i != strArray.length-1 ? strArray[i] + ", " : strArray[i]);
        }
        System.out.println();
    }
    public void two(){
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int[][] nArray = new int[number1][number1];
        for(int i = 0; i < nArray.length; i++){
            for(int j = 0; j < nArray[i].length; j++){
                System.out.print(j != nArray[i].length-1 ? j+i+1 + ", " : j+i+1 + "");
            }
            System.out.println();
        }

        int number2 = scanner.nextInt();
        char[][] square = new char[number2][number2];
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                if(i == 0){
                    if(j == 0) {
                        System.out.print("┌");
                    }
                    else if (j == square[i].length-1){
                        System.out.print("┐");
                    }
                    else {
                        System.out.print("─");
                    }
                }
                else if (i == square.length-1){
                    if(j == 0) {
                        System.out.print("└");
                    }
                    else if (j == square[i].length-1){
                        System.out.print("┘");
                    }
                    else {
                        System.out.print("─");
                    }
                }
                else {
                    if(j == 0 || j == square[i].length-1) {
                        System.out.print("│");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        char[][] chDiamond = new char[7][7];
        for(int i = 0; i < chDiamond.length; i++){
            for(int j = 0; j < Math.abs(i-chDiamond.length/2); j++){
                System.out.print(" ");
            }
            for(int j = 0; j < chDiamond.length - Math.abs(i-chDiamond.length/2)*2; j++){
                System.out.print("*");
            }
            for(int j = 0; j < Math.abs(i-chDiamond.length/2); j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
