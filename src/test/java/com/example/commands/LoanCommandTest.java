package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCommandTest {
    @Test
    void shouldBeAbleToCreateALoanWithLoanCommand() throws UnknownUserException {
        LoanCommand loanCommand = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        Ledger ledger = new Ledger("IDI");
        Status status = loanCommand.execute(ledger);

        Status expectedStatus = new Status("IDI", 0,12);
        assertEquals(expectedStatus,status);
    }
}