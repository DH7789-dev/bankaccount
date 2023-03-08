package com.kata.bankaccount.application.command.account.create;


import com.kata.bankaccount.kernel.command.Command;

public class CreateAccount implements Command {

    public final int amount;


    public CreateAccount(int amount) {
        this.amount = amount;

    }

}
