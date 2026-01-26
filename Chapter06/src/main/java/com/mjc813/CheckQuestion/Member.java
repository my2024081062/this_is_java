package com.mjc813.CheckQuestion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member {
    protected String name;
    protected String id;
    protected String password;
    protected int age;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
        this.password = null;
        this.age = 0;
    }
}
