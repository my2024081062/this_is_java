package org.example.aNewCh12;

public class Annotations {
    @PrintAnnotation
    public void method1(){
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*")
    public void method2(){
        System.out.println("실행 내용1");
    }

    @PrintAnnotation(value = "#", number = 25)
    public void method3(){
        System.out.println("실행 내용1");
    }
}
