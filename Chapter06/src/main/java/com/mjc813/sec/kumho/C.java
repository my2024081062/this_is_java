package com.mjc813.sec.kumho;
import com.mjc813.sec.hankook.A;
public class C {
    A a1 = new A(true);
//    A a2 = new A(1);
//    A a3 = new A("문자열");
    public C(){
        A a = new A();
        a.f1 = 1;
//      a.f2 = 1; default
//      a.f3 = 1; private

        a.m1();
//      a.m2(); default
//      a.m3(); private
    }
}
