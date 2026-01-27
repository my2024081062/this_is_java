package ch07.sec.C_and_D;

import ch07.sec.A_and_B.ProtectedA;

public class ProtectedD extends ProtectedA {

    public ProtectedD(){
        super();
    }

    public void method1(){
        this.field = "value";
        this.method();
    }

    public void method2(){
        ProtectedA a = new ProtectedA(); //객체 생성은 된다.
//        a.field = "value";
//        a.method();
    }
}
