package com.example.service;

import com.example.commands.BalanceCommandResult;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionStatusTest {

    @Test
    void printerPrintsTheResultWhenThereIsNoError() {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setResult(new BalanceCommandResult("bank", "name", "22","12"));

        transactionStatus.print(x -> assertEquals("bank name 22 12",x));

    }

    @Test
    void printerPrintsTheErrorWhenThereIsError() {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new UnknownUserException("name"));

        transactionStatus.print(x -> assertEquals("User name not found",x));

    }
}