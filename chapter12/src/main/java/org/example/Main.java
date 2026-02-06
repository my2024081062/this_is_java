package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UseObject uo1 = new UseObject();
        UseObject uo2 = new UseObject();
        if(uo1.equals(uo2)){
            System.out.println("같습니다.");
        }
        else {
            System.out.println("다릅니다.");
        }
    }
}