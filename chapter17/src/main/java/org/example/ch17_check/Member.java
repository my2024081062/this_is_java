package org.example.ch17_check;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private String name;
    private String job;
    private int age;

    @Override
    public String toString() {
        return "{name:" + name + ", job:" + job + ", age:" + age + "}";
    }
}
