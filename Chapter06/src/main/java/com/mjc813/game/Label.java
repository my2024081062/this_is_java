package com.mjc813.game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label {
    private final int width;
    private final int height;
    private String text;

    public Label(String text) {
        this.text = text;
        this.width = 100;
        this.height = 40;
    }

    public Label(String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;
    }
}
