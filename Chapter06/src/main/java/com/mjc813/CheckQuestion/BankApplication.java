package com.mjc813.CheckQuestion;

import java.util.Scanner;

public class BankApplication {
    private static int id = 0;
    public Account[] accounts = new Account[100];

    public void createAcount(String num, String name, int balance){
        if(id==100) return;
        Account acc = new Account(num,name,balance);
        accounts[id++] = acc;
    }


}
