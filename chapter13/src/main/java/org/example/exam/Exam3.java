package org.example.exam;

public class Exam3 {
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.setContent(t);
        return box;
    }

    public void exam3(){
        Box<Integer> box1 = Exam3.boxing(100);
        int intValue = box1.getContent();
        System.out.println(intValue);

        Box<String> box2 = Exam3.boxing("100");
        String strValue = box2.getContent();
        System.out.println(strValue);
    }
}
