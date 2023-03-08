package com.kata.bankaccount.web.controller;

import com.kata.bankaccount.application.command.account.create.CreateAccount;
import com.kata.bankaccount.application.command.account.deposit.DepositAccount;
import com.kata.bankaccount.application.command.account.withdrawal.WithdrawalAccount;
import com.kata.bankaccount.application.query.account.RetrieveBalanceAccount;
import com.kata.bankaccount.application.query.transaction.RetrieveTransaction;
import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.kernel.command.CommandBus;
import com.kata.bankaccount.kernel.query.QueryBus;
import com.kata.bankaccount.web.request.AccountRequest;
import com.kata.bankaccount.web.request.DepositAccountRequest;
import com.kata.bankaccount.web.request.WithdrawalAccountRequest;
import com.kata.bankaccount.web.response.AccountResponse;
import com.kata.bankaccount.web.response.TransactionResponse;
import com.kata.bankaccount.web.response.TransactionsResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public AccountController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }


    @GetMapping(path = "/transactions", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TransactionsResponse> getAllTransaction() {
        final List<Transaction> Transactions = queryBus.send(new RetrieveTransaction());
        TransactionsResponse TransactionsResponseResult = new TransactionsResponse(Transactions.stream().map(
                Transaction -> new TransactionResponse(Transaction.getId().getValue(),Transaction.getTransactionType(),Transaction.getDateOfValidate()) ).collect(Collectors.toList()));
        return ResponseEntity.ok(TransactionsResponseResult);
    }

    @GetMapping(path = "/actual/{accountId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountResponse> getActualBalance(@PathVariable int accountIdPath) {
        AccountId requestId = AccountId.of(accountIdPath);
        RetrieveBalanceAccount retrieveBalanceAccount = new RetrieveBalanceAccount(requestId);
        Account account = queryBus.send(retrieveBalanceAccount);
        AccountResponse accountResponse = new AccountResponse(account.getId().getValue(),account.getAmount());
         return ResponseEntity.ok(accountResponse);
    }

    @PostMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountId> create(@RequestBody @Valid AccountRequest request) {
        CreateAccount createAccount = new CreateAccount(request.amount);
        AccountId accountId = commandBus.send(createAccount);
        return ResponseEntity.ok(accountId);
    }

    @PostMapping(path = "/deposit/{accountId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deposit(@RequestBody @Valid DepositAccountRequest request, @PathVariable int accountIdPath) {
        AccountId requestId = AccountId.of(accountIdPath);
        DepositAccount createAccount = new DepositAccount(requestId,request.deposit);
        AccountId accountId = commandBus.send(createAccount);
        return ResponseEntity.created(URI.create("/account/deposit" + accountId.getValue())).build();
    }

    @PostMapping(path = "/withdrawal/{accountId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> withdrawal(@RequestBody @Valid WithdrawalAccountRequest request, @PathVariable int accountIdPath) {
        AccountId requestId = AccountId.of(accountIdPath);
        WithdrawalAccount createAccount = new WithdrawalAccount(requestId,request.withdrawal);
        AccountId accountId = commandBus.send(createAccount);
        return ResponseEntity.created(URI.create("/account/withdrawal" + accountId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
       
    }
}


