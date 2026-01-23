package com.mjc813;

public class Chapter06 {
    private String ch06;

    public Chapter06 (){
        this("기본");
    }

    public Chapter06 (String ch06){
        this.ch06 = ch06;
    }
    public void runTest(){
        this.runTest(null,null);
    }

    public void runTest(String s){
        this.runTest(s,null);
    }

    public void runTest(String s, String i){
        System.out.println("runTest : ch06 " + this.ch06 + (s == null ? "" : ", 문자열 : " + s) + (i == null ? "" : ", 숫자 : " + i));
    }
}
