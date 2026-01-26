package com.mjc813.game;
import java.util.Scanner;
public class Input {
    String text = "";
    int width;
    int height;

    public Input(String text) {
        this.text = text;
        this.width = 200;
        this.height = 40;
    }

    public void inputText(){
        Scanner s = new Scanner(System.in);
        text = s.next();
    }
}
