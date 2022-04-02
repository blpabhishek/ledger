package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Loan;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceCommandTest {

    @Test
    void shouldFetchTheUsersBalance() throws UnknownUserException {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 0);
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("Bob", new Loan(200, 1, 1));
        Status status = balanceCommand.execute(ledger);

        Status expectedStatus = new Status("IDI", 0, 12);
        assertEquals(expectedStatus, status);
    }

    @Test
    void shouldThrowExceptionForInvalidUser() {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 1);
        Ledger ledger = new Ledger("IDI");

        assertThrows(UnknownUserException.class,()->balanceCommand.execute(ledger));
    }
}