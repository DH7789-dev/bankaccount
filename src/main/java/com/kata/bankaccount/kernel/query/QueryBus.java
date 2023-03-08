package com.kata.bankaccount.kernel.query;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}
