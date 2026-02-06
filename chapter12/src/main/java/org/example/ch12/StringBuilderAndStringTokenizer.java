package org.example.ch12;

import java.util.StringTokenizer;

public class StringBuilderAndStringTokenizer {
    public void doStringBuilder(){
        String data = new StringBuilder()
            .append("DEF")
            .insert(0,"ABC")
            .delete(3,4)
            .toString();
        System.out.println(data);
    }
    public void doStringTokenizer(){
        String data1 = "h&l,p";
        String[] data1Arr = data1.split("[&,]");

        for(String token1 : data1Arr){
            System.out.println("token1: " + token1);
        }

        String data2 = "h/l/p";
        StringTokenizer stringTokenizer = new StringTokenizer(data2,"/");
        while (stringTokenizer.hasMoreTokens()){
            String token2 = stringTokenizer.nextToken();
            System.out.println("token2: " + token2);
        }
    }
}
