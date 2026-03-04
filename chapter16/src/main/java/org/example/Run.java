package org.example;

public class Run {
    public void runRamda(){
        String str = "zxcv";
        int num = 4;
        this.ramda((s,n)->{
            boolean check = s.length() == n;
            System.out.println("str의 길이와 num이 " + (check ? "일치합니다." : "불일치합니다."));
        },str,num);
        this.ramda((s,n)->{
            for(int i = 0; i < n; i++){
                System.out.print(s);
            }
            System.out.println();
        },str,num);
    }

    public void runInherit(){
        String str = "qwerty";
        int num = 6;
        RamdaInterface checkLengthAndNum = new CheckLengthAndNum();
        RamdaInterface printStringRepeatNum = new PrintStringRepeatNum();
        this.ramda(checkLengthAndNum,str,num);
        this.ramda(printStringRepeatNum,str,num);
    }
    public void runDoubleColon(){
        UseDoubleColon useDoubleColon = new UseDoubleColon();
        this.ramda((useDoubleColon :: procString), "",0);
    }
    public void runConstructor(){
        this.ramda((AnyClass :: new), "아무 클래스",1);
    }

    public void ramda(RamdaInterface ramdaInterface, String str, int num){
        ramdaInterface.procString(str,num);
    }
}
