package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrintOneLetter extends Thread{
    private static PrintOneLetter printOneLetter = null;
    private String letter = "";

    private PrintOneLetter(){}

    public static PrintOneLetter getPrintOneLetter(){
        if(printOneLetter == null){
            printOneLetter = new PrintOneLetter();
        }
        return printOneLetter;
    }

    @Override
    public void run() {
        while (true){
            if(!letter.isEmpty()){
                System.out.print(this.getLetter().charAt(0) + " ");
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {

            }
        }
    }
}
