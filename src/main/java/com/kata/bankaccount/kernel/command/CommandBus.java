package com.kata.bankaccount.kernel.command;

public interface CommandBus {
    <C extends Command, R> R send(C command);
}
