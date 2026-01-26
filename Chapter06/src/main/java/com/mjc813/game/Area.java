package com.mjc813.game;

public class Area {
    private static int auto = 0;
    int id;
    int width;
    int height;

    private int size = 0;
    Block[] blocks = new Block[0];

    public Area() {
        id = auto++;
        this.width = 600;
        this.height = 400;
    }

    public Area(int width, int height) {
        id = auto++;
        this.width = width;
        this.height = height;
    }

    public void add(Block block){
        size += 1;
        this.resizing(block);
    }
    private void resizing(Block block){
        Block[] resize = new Block[size];
        System.arraycopy(blocks, 0, resize, 0, blocks.length);
        resize[size-1] = block;
        blocks = resize;
    }
}
