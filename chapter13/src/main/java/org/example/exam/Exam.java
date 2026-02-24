package org.example.exam;

public class Exam {
    public void doPackaging(){
        Packaging<Human> humanPackaging = new Packaging<>();
        humanPackaging.add(new Human("lsh",24));
        humanPackaging.add(new Human("csk",23));
        humanPackaging.add(new Human("psk",24));
//        humanPackaging.add(new String()); 오류
        Human human = humanPackaging.remove();
        System.out.println(human.getName());

        Packaging<String> stringPackaging = new Packaging<>();
        stringPackaging.add("abc");
        stringPackaging.add("def");
        String s = stringPackaging.remove();
        System.out.println(s);
    }
}
