package org.example.exam;

public class Exam4 {
    public static <T extends Number> boolean compare(T t1, T t2){
        System.out.println("compare("+t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName()+")");

        double v1 = t1.doubleValue(); //extends하니까 그 클래스의 메소드를 사용할 수 있다.
        double v2 = t2.doubleValue();

        return v1 == v2;
    }

    public void exam4(){
        boolean result1 = Exam4.compare(10,20);
        System.out.println(result1);
        System.out.println();

        boolean result2 = Exam4.compare(4.5,4.5);
        System.out.println(result2);
        System.out.println();
    }
}
