package ch08;
import ch08.sec.electronics.*;
import ch08.sec.mjc813.Mjc813Human;
import ch08.sec.test.DoInterfaces;
import ch08.sec.test.*;

public class Main {
    public static void main(String[] args) {
        Mjc813Human m8h = new Mjc813Human();
        m8h.study();
        MyCalculator<Integer> mci = new MyCalculator<>();
        MyCalculator<Double> mcd = new MyCalculator<>();
        System.out.println(mci.add(12,34));
        System.out.println(mcd.add(1.2,3.4));

        DoImpl di = new DoImpl();
        di.doElectronics();
        di.doService();

        RemoteControl stv = new SmartTelevision();
        stv.turnOn();
        stv.turnOff();

        Searchable sc = new SmartTelevision();
        sc.search("https://www.youtube.com/");

        InterfaceA ia = new DoInterfaces();
        ia.methodA();
        InterfaceB ib = new DoInterfaces();
        ib.methodB();
        InterfaceC ic = new DoInterfaces();
        ic.methodC();
    }
}