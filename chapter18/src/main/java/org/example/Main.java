package org.example;

import org.example.data.GameType;
import org.example.data.Grade;
import org.example.data.Human;
import org.example.data.NintendoGame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Human human = new Human("나",19);
        human.getGameList().add(new NintendoGame("마리오 카트",15000, Grade.ALL, GameType.ARCADE));
        human.getGameList().add(new NintendoGame("마리오 파티",15000, Grade.ALL, GameType.ARCADE));
        human.getGameList().add(new NintendoGame("마리오",15000, Grade.ALL, GameType.ARCADE));
        fileOutput();
        
    }
    public static void fileOutput(){
        OutputStream os = null;
        try {
            os = new FileOutputStream("./test.db");
            os.write(10);
            os.write(20);
            os.write(30);
            os.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(os != null){
                    os.close();
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}