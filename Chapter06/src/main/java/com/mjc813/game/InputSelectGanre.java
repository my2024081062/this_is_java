package com.mjc813.game;

public class InputSelectGanre extends InputSelect {
    private Ganre ganre;

    public InputSelectGanre(Ganre ganre) {
        super(); // This calls the parent class constructor
        this.ganre = ganre;
        this.selectList();
    }
    public InputSelectGanre(Ganre ganre, int width, int height) {
        super(width,height); // This calls the parent class constructor
        this.ganre = ganre;
        this.selectList();
    }

    public void selectList(int findIndex){}
    public void selectList(){
        switch (ganre){
            case RPG -> this.selectedItem = "RPG";
            case ACTION -> this.selectedItem = "액션";
            case SPORTS -> this.selectedItem = "스포츠";
        }
    }
    public void setGanre(String s) {
        switch (s){
            case "RPG" -> this.ganre = Ganre.RPG;
            case "액션" -> this.ganre = Ganre.ACTION;
            case "스포츠" -> this.ganre = Ganre.SPORTS;
        }
        this.selectList();
    }
}
