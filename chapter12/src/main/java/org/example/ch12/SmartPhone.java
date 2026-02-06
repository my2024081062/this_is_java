package org.example.ch12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class SmartPhone {
    private String company;
    private String os;

    @Override
    public String toString() {
        return company + ", " + os;
    }


}
