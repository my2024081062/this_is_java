package ch07.sec.sugang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Subject {
    private static int subId = 0;
    private final int id;
    private String name;
    private int hakjum;
    private String major;

    public Subject(String name, int hakjum, String major) {
        this.id = subId++;
        this.name = name;
        this.hakjum = hakjum;
        this.major = major;
    }
}
