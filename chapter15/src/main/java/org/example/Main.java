package org.example;

import org.example.exam.InputNintendoGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        String[] key = {"ABACD", "BCEFD"};
//        String[] target = {"ABCD","AABB"};
//        int[] a = s.solution(key,target);
//        System.out.println(a[0]);
        Collect collect = new Collect();
        collect.collect();

        InputNintendoGame inputNintendoGame = new InputNintendoGame();
        inputNintendoGame.work();
    }
}

//class Solution {
//    public int[] solution(String[] keymap, String[] targets) {
//        int[] answer = new int[targets.length];
//        for(int I = 0; I < targets.length;I++){
//            int J = 0;
//            while(J<targets[I].length()){
//                for(int i = 0; i < 100; i++){
//                    if(J >= targets[I].length()){
//                        break;
//                    }
//                    for(int j = 0;j<keymap.length;j++){
//                        if(J >= targets[I].length()){
//                            break;
//                        }
//                        else{
//                            if(targets[I].charAt(J) == keymap[j].charAt(i)){
//                                answer[I]+=(i+1);
//                                J++;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if(answer[I] == 0) answer[I] = -1;
//            }
//        }
//        return answer;
//    }
//}