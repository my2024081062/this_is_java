package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class GameList<G> {
    private List<G> gameList;

    public GameList(){
        this.gameList = new ArrayList<>();
    }

    public G add(G game){
        if(this.gameList.add(game)){
            return game;
        }
        else{
            return null;
        }
    }
    public G remove(int index){
        if(index <= -1 || index >= this.gameList.size()){
            return null;
        }
        return this.gameList.remove(index);
    }

}
