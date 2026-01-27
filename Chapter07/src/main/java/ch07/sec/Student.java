package ch07.sec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int hackbun;
    private String name;
    private String major;
    private double grade;
}
