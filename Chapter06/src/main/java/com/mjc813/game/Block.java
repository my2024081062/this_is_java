package com.mjc813.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {
    private static int auto = 0;
    int id;
    int width;
    int height;

    Label[] labels = new Label[0];
    Image image = null;
    Input input = null;
    InputSelect inputSelect = null;
    InputSelectGanre inputSelectGanre = null;
    InputSelectRate inputSelectRate = null;

    public Block() {
        id = auto++;
        this.width = 550;
        this.height = 80;
    }

    public Block(int width, int height) {
        id = auto++;
        this.width = width;
        this.height = height;
    }

    public void add(Label label){
        Label[] resizing = new Label[labels.length+1];
        System.arraycopy(labels, 0, resizing, 0, labels.length);
        this.labels = resizing;
    }
    public void add(Image image){
        this.image = image;
    }
    public void add(Input input){
        if(inputSelectRate != null || inputSelect != null || inputSelectGanre != null) return;
        this.input = input;
    }
    public void add(InputSelect inputSelect){
        if(input != null || inputSelectGanre != null || inputSelectRate != null) return;
        this.inputSelect = inputSelect;
    }
    public void add(InputSelectGanre inputSelectGanre){
        if(input != null || inputSelect != null || inputSelectRate != null) return;
        this.inputSelectGanre = inputSelectGanre;
    }
    public void add(InputSelectRate inputSelectRate){
        if(input != null || inputSelect != null || inputSelectGanre != null) return;
        this.inputSelectRate = inputSelectRate;
    }
}
