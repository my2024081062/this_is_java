package ch07.sec.C_and_D;

public class ProtectedC {
    public void method(){
//      ProtectedA a = new ProtectedA();
        ch07.sec.A_and_B.ProtectedA a = new  ch07.sec.A_and_B.ProtectedA();
//      a.field = "value";
        a.setField("value");
//      a.method();
    }

}
