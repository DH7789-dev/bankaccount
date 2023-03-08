package com.kata.bankaccount.kernel.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
