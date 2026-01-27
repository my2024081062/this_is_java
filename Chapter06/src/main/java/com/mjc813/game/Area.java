package com.mjc813.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Area {
    private static int auto = 0;
    private int id;
    private int width;
    private int height;

    private int size = 0;
    private Block[] blocks = new Block[0];

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

    public void del(int id){
        if (size == 1){
            blocks = new Block[0];
        }
        else {
            for(int i = 0; i < size; i++){
                if(blocks[i].getId() == id){
                    Block[] reBlock = new Block[size-1];
                    for(int j = 0; j < i; j++){

                    }
                }
                else return;
            }
        }
    }

    private void resizing(Block block){
        Block[] resize = new Block[size];
        System.arraycopy(blocks, 0, resize, 0, blocks.length);
        resize[--size] = block;
        blocks = resize;
    }

    public void showBlockId(){
        for(int i = 0; i < blocks.length; i++){
            System.out.print(",블럭 id: " + blocks[i].getId());
        }
    }
}
