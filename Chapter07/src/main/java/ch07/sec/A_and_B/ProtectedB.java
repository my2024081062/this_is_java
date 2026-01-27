package ch07.sec.A_and_B;

public class ProtectedB {

    public void method(){
        ProtectedA a = new ProtectedA();
        a.field = "value"; //실습
        a.method();
    }
}
