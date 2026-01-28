package com.mjc813.game;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

@Getter
@Setter
public class InputSelect {
    protected String[] list;
    protected String selectedItem;
    private int width;
    private int height;


    public InputSelect() {
        this.list = new String[0]; // Initialize with empty array by default
        this.selectList(0);
        this.width = 200;
        this.height = 40;
    }
    public InputSelect(int width, int height) {
        this();
        this.width = width;
        this.height = height;
    }
    
    public InputSelect(String[] list, int width, int height) {
        this.list = list != null ? list : new String[0];
        this.selectList(0);
        this.width = width;
        this.height = height;
    }

    public void selectList(int findIndex){
        selectedItem = list.length == 0 ? null : list[findIndex];
    }

    public void selectList(){
        Scanner s = new Scanner(System.in);
        int findIndex = s.nextInt();
        selectedItem = list.length == 0 ? null : list[findIndex];
    }
    protected void setSelect(String s){}
    public String getSelectedItem() {
        return selectedItem == null ? "" : selectedItem ;
    }
}
