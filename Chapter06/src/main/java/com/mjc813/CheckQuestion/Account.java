package com.mjc813.CheckQuestion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account {
    public static final int MIN_BALANCE = 0;
    public static final int MAX_BALANCE = 1000000;

    private String accountNumber;
    private String accountName;
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance < MIN_BALANCE ? this.balance : balance > MAX_BALANCE ? this.balance : balance;
    }
    public void setBalance(String accountNumber, int balance) {
        this.balance += balance;
    }

}
