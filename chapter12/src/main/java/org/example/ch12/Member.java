package org.example.ch12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private String id;

    public boolean equals(Object obj) {
        if(obj instanceof Member target){
            return this.getId().equals(target.getId());
        }
        return false;
    }

    public void member(){
        Member mem1 = new Member("123");
        Member mem2 = new Member("123");
        Member mem3 = new Member("234");

        if(mem1.equals(mem2)){
            System.out.println("같습니다.");
        }
        else{
            System.out.println("다릅니다.");
        }
        if(mem1.equals(mem3)){
            System.out.println("같습니다.");
        }
        else{
            System.out.println("다릅니다.");
        }
    }
}
