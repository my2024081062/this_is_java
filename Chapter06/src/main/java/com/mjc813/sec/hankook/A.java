package com.mjc813.sec.hankook;

public class A {
    A a1 = new A(true);
    A a2 = new A(1);
    A a3 = new A("문자열");

    public A(boolean b){
    }
    A(int b) {
    }
    private A(String s){
    }

    public A(){
        f1=1; f2=1; f3=1;
        m1(); m2(); m3();
    }

    public int f1;
    int f2;
    private int f3;

    public void m1(){}
    void m2(){}
    private void m3(){}
}
