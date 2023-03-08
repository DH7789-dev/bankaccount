package com.kata.bankaccount.web.response;

public class AccountResponse {

    public int id;
    public int amount;

    public AccountResponse(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +

                "ammout='" + id + '\'' +
                ",ammout='" + amount + '\'' +
                '}';
    }
}
