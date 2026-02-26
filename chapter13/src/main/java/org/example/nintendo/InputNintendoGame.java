package org.example.nintendo;

public class InputNintendoGame {
    public void work(){
        NintendoGame nintendoGame1 = new NintendoGame("마리오1",Grade.ALL,10000);
        NintendoGame nintendoGame2 = new NintendoGame("마리오2",Grade.ALL,15000);
        NintendoGame nintendoGame3 = new NintendoGame("마리오3",Grade.ALL,20000);
        Myclass<NintendoGame> myclass = new Myclass<>();
        myclass.add(nintendoGame1);
        myclass.add(nintendoGame2);
        myclass.add(nintendoGame3);
        System.out.println(myclass.getJsonAllItems());

        System.out.println("myclass.set(1,new NintendoGame(\"별의 커비\",Grade.ALL,13000))");
        myclass.set(1,new NintendoGame("별의 커비",Grade.ALL,13000));
        System.out.println(myclass.getJsonAllItems());

        System.out.println("myclass.remove(1)");
        myclass.remove(1);
        System.out.println(myclass.getJsonAllItems());
    }
}
