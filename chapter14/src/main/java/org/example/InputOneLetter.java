package org.example;

import java.util.Scanner;

public class InputOneLetter extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        PrintOneLetter printOneLetter = PrintOneLetter.getPrintOneLetter();
        while (true){
            String letter = scanner.nextLine();
            printOneLetter.setLetter(letter);
        }
    }
}
