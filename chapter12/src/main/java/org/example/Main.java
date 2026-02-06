package org.example;

import org.example.ch12.DoExit;
import org.example.ch12.DoCh12Example;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, Exception{
//        UseObject uo1 = new UseObject("a1","a1.use");
//        UseObject uo2 = new UseObject("a1","a1.use");
//        if(uo1.equals(uo2)){
//            System.out.println("같습니다.");
//        }
//        else {
//            System.out.println("다릅니다.");
//        }
//
//        UseObject uo3 = (UseObject) uo1.clone();//복사
//        if(uo1.equals(uo3)){
//            System.out.println("같습니다.");
//        }
//        else {
//            System.out.println("다릅니다.");
//        }
//        uo3.setName("a1.not use");
//        System.out.println(uo1);
//        System.out.println(uo2);
//        System.out.println(uo3);
//
//        HashSet<UseObject> useObjectHashSet = new HashSet<>();
//        System.out.println("useObjectHashSet.add(uo1); 결과 : " + useObjectHashSet.add(uo1));
//        System.out.println("useObjectHashSet.remove(new Object()); 결과 : " + useObjectHashSet.remove(new Object()));
//        System.out.println("useObjectHashSet.remove(uo1); 결과 : " + useObjectHashSet.remove(uo1));

//        Hash hash1 = new Hash();
//        hash1.hash1();
//        hash1.hash2();
//        hash1.hash3();

        DoCh12Example doCh12Example = new DoCh12Example();
        doCh12Example.doSomething();

        DoExit doExit = new DoExit();
        doExit.doExit();
    }
}