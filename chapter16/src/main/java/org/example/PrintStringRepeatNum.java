package org.example;

public class PrintStringRepeatNum implements RamdaInterface{
    @Override
    public void procString(String str, int num) {
        for(int i = 0; i < num; i++){
            System.out.print(str);
        }
        System.out.println();
    }
}
