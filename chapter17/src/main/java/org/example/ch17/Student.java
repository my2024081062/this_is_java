package org.example.ch17;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score,o.score);
    }
}
