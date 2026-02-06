package org.example.ch12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@AllArgsConstructor
@Setter
@Getter
public class Student {
    private int num;
    private String name;

    @Override
    public int hashCode() {
        return num + name.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student student1
            && this.hashCode() == student1.hashCode()
            && this.getNum() == student1.getNum()
            && this.getName().equals(student1.getName());
    }
    public void student(){
        Student student1 = new Student(1,"h");
        Student student2 = new Student(1,"h");
        Student student3 = new Student(2,"h");

        if(student1.equals(student2)){
            System.out.println("같습니다.");
        }
        else{
            System.out.println("다릅니다.");
        }

        if(student1.equals(student3)){
            System.out.println("같습니다.");
        }
        else{
            System.out.println("다릅니다.");
        }
    }

    public void studentHashSet(){
        HashSet<Student> studentHashSet = new HashSet<>();
        Student student1 = new Student(1,"h");
        Student student2 = new Student(1,"h");
        Student student3 = new Student(2,"h");

        studentHashSet.add(student1);
        System.out.println("객체 수 : " + studentHashSet.size());

        studentHashSet.add(student2);
        System.out.println("객체 수 : " + studentHashSet.size());

        studentHashSet.add(student3);
        System.out.println("객체 수 : " + studentHashSet.size());
    }
}
