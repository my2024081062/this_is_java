package org.example;

public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        String[][] pad = new String[4][3];
        for(int i = 0; i < pad.length;i++){
            for(int j = 0; j < pad[i].length;j++){
                pad[i][j] = "";
            }
        }
        pad[3][0] = "left";
        pad[3][2] = "right";
        int index = 0;
        for(int i = 0; i < pad.length;i++){
            for(int j = 0; j < pad[i].length;j++){
                int indexC = numbers[index] == 0 ? 10 : numbers[index]-1;
                int indexI = indexC / 3;
                int indexJ = indexC % 3;
                int indexL = getIndex(pad,"left");
                int indexR = getIndex(pad,"right");
                int defL = Math.abs(indexI - indexL / 3) + Math.abs(indexJ - indexL % 3);
                int defR = Math.abs(indexI - indexR / 3) + Math.abs(indexJ - indexR % 3);
                if(i == 0){
                    answer.append("L");
                    pad[indexI][indexJ] = "";
                    pad[indexC / 3][indexC % 3] = "left";
                }
                else if(i == 2) {
                    answer.append("R");
                    pad[indexI][indexJ] = "";
                    pad[indexC / 3][indexC % 3] = "right";
                }
                else {
                    if(defL < defR){
                        answer.append("L");
                        pad[indexI][indexJ] = "";
                        pad[indexC / 3][indexC % 3] = "left";
                    }
                    else if(defL > defR){
                        answer.append("R");
                        pad[indexI][indexJ] = "";
                        pad[indexC / 3][indexC % 3] = "right";
                    }
                    else {
                        if(hand.equals("left")){
                            answer.append("L");
                            pad[indexI][indexJ] = "";
                            pad[indexC / 3][indexC % 3] = "left";
                        }
                        else {
                            answer.append("R");
                            pad[indexI][indexJ] = "";
                            pad[indexC / 3][indexC % 3] = "right";
                        }
                    }
                }
                index++;
            }
        }
        return answer.toString();
    }
    private int getIndex(String[][] pad,String lr){
        for(int i = 0; i < pad.length;i++){
            for(int j = 0; j < pad[i].length;j++){
                if(pad[i][j].equals(lr)){
                    return i*3+j;
                }
            }
        }
        return 0;
    }
}