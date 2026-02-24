package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    public String name;
    public int age;

    @Override
    public int hashCode(){
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member Hash1){
            return Hash1.name.equals(this.getName()) && Hash1.getAge() == this.getAge();
        }
        return false;
    }
}
