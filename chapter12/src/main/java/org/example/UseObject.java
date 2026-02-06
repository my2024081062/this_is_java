package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseObject {
    private String id;
    private String name;

    @Override
    protected Object clone(){
        return this;
    }

    @Override
    public boolean equals(Object obj){
        if(this.hashCode() == obj.hashCode()){
            return true;
        }
        else {
            return false;
        }
    }
}
