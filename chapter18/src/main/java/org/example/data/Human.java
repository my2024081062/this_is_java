package org.example.data;

import lombok.Getter;

@Getter
public class Human {
    private String name;
    private Integer age;
    private GameList<NintendoGame> gameList;

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.gameList = new GameList<>();
    }
}
