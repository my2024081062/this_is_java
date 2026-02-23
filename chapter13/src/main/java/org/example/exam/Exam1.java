package org.example.exam;

public class Exam1 {
    public void exam1(){
        Box<String> box1 = new Box<>();
        box1.setContent("안녕하세요.");
        String str = box1.getContent();
        System.out.println(str);

        Box<Integer> box2 = new Box<>();
        box2.setContent(100);
        Integer val = box2.getContent();
        System.out.println(val);
    }
}
