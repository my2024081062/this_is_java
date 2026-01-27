package com.mjc813.game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String url;
    private final int width;
    private final int height;

    public Image(int width, int height, String url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }
    public Image(String url) {
       this(500,100, url);
    }
}
