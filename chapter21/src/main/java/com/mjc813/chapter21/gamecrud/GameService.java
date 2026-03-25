package com.mjc813.chapter21.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
