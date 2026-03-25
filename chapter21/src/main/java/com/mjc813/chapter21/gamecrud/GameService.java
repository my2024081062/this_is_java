package com.mjc813.chapter21.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameMybatis gameMybatis;

    public void insertData(GameDto gameDto){
        this.gameMybatis.insertData(gameDto);
    }

    public void updateData(GameDto gameDto){
        this.gameMybatis.updateData(gameDto);
    }

    public void deleteData(GameDto gameDto){
        this.gameMybatis.deleteData(gameDto);
    }

    public List<GameDto> getAllGames(){
        return this.gameMybatis.getAllGames();
    }
}
