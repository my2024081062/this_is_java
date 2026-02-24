package org.example.exam;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Box <T>{
    private T content;

    public boolean compare(Box<T> other){
        return this.getContent().equals(other.getContent());
    }
}



