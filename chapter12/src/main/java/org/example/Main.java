package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UseObject uo1 = new UseObject("a1","a1.use");
        UseObject uo2 = new UseObject("a1","a1.use");
        if(uo1.equals(uo2)){
            System.out.println("같습니다.");
        }
        else {
            System.out.println("다릅니다.");
        }

        UseObject uo3 = (UseObject)uo1.clone();
        if(uo1.equals(uo3)){
            System.out.println("같습니다.");
        }
        else {
            System.out.println("다릅니다.");
        }
    }
}