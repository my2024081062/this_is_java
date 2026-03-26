package com.mjc813.chapter21.gamecrud;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMybatis {
    void insertData(GameDto gameDto);
    void updateData(GameDto gameDto);
    void deleteData(GameDto gameDto);
    GameDto findById(Integer id);
    List<GameDto> getAllGames();
}
