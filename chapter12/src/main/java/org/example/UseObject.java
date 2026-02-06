package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UseObject {
    private String id;
    private String name;

    @Override
    protected Object clone(){
        return this;
    }

    @Override
    public boolean equals(Object obj){
//        if(this.hashCode() != obj.hashCode()){
//            return false;
//        }
        if(obj instanceof UseObject ob
            && this.getId().equals(ob.getId())
            && this.getName().equals(ob.getName())
            && this.hashCode() == ob.hashCode())
        {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
