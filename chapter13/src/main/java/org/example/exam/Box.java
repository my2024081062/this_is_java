package org.example.exam;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Box <T>{
    private T content;
}
