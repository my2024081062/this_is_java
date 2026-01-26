package com.mjc813.sec.hankook;

public class B {
    A a1 = new A(true);
    A a2 = new A(1);
//    A a3 = new A("문자열");
    public void m(){
        A a = new A();
        a.f1 = 1;
        a.f2 = 1;
//      a.f3 = 1; private
        a.m1();
        a.m2();
//      a.m3(); private
    }
}
