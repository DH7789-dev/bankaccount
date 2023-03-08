package com.kata.bankaccount.kernel.exeption;


import com.kata.bankaccount.kernel.command.Command;

public class NoSuchCommandExecption extends RuntimeException {

    public NoSuchCommandExecption(String message) {
        super(message);
    }

    public static NoSuchEntityException withGetClass(Command command) {
        return new NoSuchEntityException(String.format("No such command handler for " + command.getClass().getName()));
    }



}
