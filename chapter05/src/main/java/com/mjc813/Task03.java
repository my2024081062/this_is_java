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
            nArray[i] = (int) dArray[i];
            sum += nArray[i];
        }
        System.out.println("전체 원소들의 합 : " +  sum);
        System.out.println("전체 원소들의 평균 : " +  sum/25);

        String[] strArray = new String[25];
        for (int i = 0; i< strArray.length; i++){
            strArray[i] = dArray[i] + " => " + (int) dArray[i];
        }
        for (int i = 0; i< strArray.length; i++){
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
                nArray[i][j] = i+j+1;
                System.out.print(j != nArray[i].length-1 ? nArray[i][j] + ", " : nArray[i][j] + "");
            }
            System.out.println();
        }

        int number2 = scanner.nextInt();
        char[][] square = new char[number2][number2];
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                if(i == 0){
                    if(j == 0) {
                        square[i][j] = '┌';
                    }
                    else if (j == square[i].length-1){
                        square[i][j] = '┐';
                    }
                    else {
                        square[i][j] = '─';
                    }
                }
                else if (i == square.length-1){
                    if(j == 0) {
                        square[i][j] = '└';
                    }
                    else if (j == square[i].length-1){
                        square[i][j] = '┘';
                    }
                    else {
                        square[i][j] = '─';
                    }
                }
                else {
                    if(j == 0 || j == square[i].length-1) {
                        square[i][j] = '│';
                    }
                    else {
                        square[i][j] = ' ';
                    }
                }
            }
        }
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                System.out.print(square[i][j]);
            }
            System.out.println();
        }

        char[][] chDiamond = new char[5][5];
        for(int i = 0; i < chDiamond.length; i++){
            int front = i - chDiamond.length/2 < 0 ? chDiamond.length/2 - i : i - chDiamond.length/2;
            int star = chDiamond.length - front*2;
            for(int j = 0; j < front; j++){
                chDiamond[i][j] = ' ';
            }
            for(int j = front; j < front + star; j++){
                chDiamond[i][j] = '*';
            }
            for(int j = front + star; j < chDiamond.length; j++){
                chDiamond[i][j] = ' ';
            }
        }

        for(int i = 0; i < chDiamond.length; i++){
            for(int j = 0; j < chDiamond[i].length; j++){
                System.out.print(chDiamond[i][j]);
            }
            System.out.println();
        }
    }
}
