package ch07.sec.from_eight_to_eleven;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student1 extends Person1 {
    public int stuNum;

    public Student1(String name, int stuNum) {
        super(name);
        this.stuNum = stuNum;
    }
    public void study() {
        System.out.println("공부합니다.");
    }
}
