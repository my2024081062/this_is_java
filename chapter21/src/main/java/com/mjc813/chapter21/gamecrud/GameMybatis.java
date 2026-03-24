package com.mjc813.chapter21.gamecrud;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMybatis {
    void insertData(GameDto gameDto);
}
