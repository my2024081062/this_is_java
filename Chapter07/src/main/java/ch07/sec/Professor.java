package ch07.sec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Professor {
    private int profNum;
    private String name;
    private String major;
}
