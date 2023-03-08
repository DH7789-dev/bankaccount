package com.kata.bankaccount.application.command.transaction;


import com.kata.bankaccount.domain.enumerate.TransactionType;
import com.kata.bankaccount.kernel.command.Command;

public class CreateTransaction implements Command {


    public final TransactionType transactionType;
    public final String dateOfValidate;


    public CreateTransaction( TransactionType transactionType, String dateOfValidate) {
        this.transactionType = transactionType;
        this.dateOfValidate = dateOfValidate;
    }

}
