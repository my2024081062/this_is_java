package ch07.sec.sugang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int hackbun;
    private String name;
    private String major;

    public void listen(Subject s, Professor p){
        if(!p.getMajor().equals("교양") && !this.getMajor().equals(p.getMajor())) {
            System.out.println("전공 과목 교수가 아닙니다.");
        }
        else{
            double grade =  Math.random() * 1.5 + 3;
            System.out.println(this.getName() + "학생이 " + p.getName() + "교수에게 " + s.getName() + "과목 수강을 듣습니다.");
            DB.getInstance(this,s,grade);
        }
    }
}
