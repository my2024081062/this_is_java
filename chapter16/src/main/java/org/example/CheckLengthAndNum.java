package org.example;

public class CheckLengthAndNum implements RamdaInterface{
    @Override
    public void procString(String str, int num) {
        boolean check = str.length() == num;
        System.out.println("str의 길이와 num이 " + (check ? "일치합니다." : "불일치합니다."));
    }
}
