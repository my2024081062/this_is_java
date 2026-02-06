package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UseObject {
    private String id;
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException{

        return new UseObject(this.getId(),this.getName());
    }

    @Override
    public boolean equals(Object obj){
//        if(this.hashCode() != obj.hashCode()){
//            return false;
//        }
        if( obj instanceof UseObject ob
            && this.hashCode() == ob.hashCode()
            && this.getId().equals(ob.getId())
            && this.getName().equals(ob.getName())
        ){
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
