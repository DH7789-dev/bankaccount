package com.kata.bankaccount.kernel;

import java.util.List;

public interface Repository<VOID, E> {

    VOID nextIdentity();

    E findById(VOID id);

    void delete(VOID id);

    void save(E e);

    List<E> findAll();

}
