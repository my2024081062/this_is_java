package org.example.check;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Check5 {
    private String studentNum;

    @Override
    public int hashCode() {
        return (int) Integer.parseInt(this.getStudentNum());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Check5 target){
            return this.hashCode() == target.hashCode();
        }
        return false;
    }
}
