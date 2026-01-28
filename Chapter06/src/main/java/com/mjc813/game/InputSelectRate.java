package com.mjc813.game;

public class InputSelectRate extends InputSelect{
    private Rated rate;

    public InputSelectRate() {
        super();
        this.selectList();
    }

    public InputSelectRate(Rated rate) {
        super(); // This calls the parent class constructor
        this.rate = rate;
        this.selectList();
    }


    public InputSelectRate(Rated rate, int width, int height) {
        super(width,height); // This calls the parent class constructor
        this.rate = rate;
        this.selectList();
    }
    public void selectList(int findIndex){}
    public void selectList(){
        switch (rate){
            case RATEDALL -> this.selectedItem = "전체이용가";
            case RATED18 -> this.selectedItem = "18세이용가";
            case RATED13 -> this.selectedItem = "13세이용가";
            case null -> this.selectedItem = null;
        }
    }

    public void setSelect(String s) {
        switch (s){
            case "전체이용가" -> this.rate = Rated.RATEDALL;
            case "18세이용가" -> this.rate = Rated.RATED18;
            case "13세이용가" -> this.rate = Rated.RATED13;
        }
        this.selectList();
    }
}
