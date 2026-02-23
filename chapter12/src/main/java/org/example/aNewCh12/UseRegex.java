package org.example.aNewCh12;

import java.util.regex.Pattern;

public class UseRegex {
    public void pattern(){
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-123-4567";
        if(Pattern.matches(regExp,data)){
            System.out.println("정규식과 일치합니다.");
        }
        else{
            System.out.println("정규식과 일치하지 않습니다.");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "mjc813@myEmailcom";
        if(Pattern.matches(regExp,data)){
            System.out.println("정규식과 일치합니다.");
        }
        else{
            System.out.println("정규식과 일치하지 않습니다.");
        }
        System.out.println("--------------------------");
    }
}
