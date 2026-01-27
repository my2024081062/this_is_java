package com.mjc813.game;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Input {
    private String text;
    private final int width;
    private final int height;

    public Input() {
        this("",200,40);
    }

    public Input(String text) {
        this(text,200,40);
    }

    public Input(String text,int width,int height) {
        this.text = text;
        this.width = width;
        this.height = height;
    }

    public void inputText(){
        Scanner s = new Scanner(System.in);
        text = s.next();
    }
}
