package com.example.parser;

import com.example.domain.Ledger;
import com.example.domain.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCommandTest {
    @Test
    void shouldBeAbleToCreateALoanWithLoanCommand() {
        LoanCommand loanCommand = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        Ledger ledger = new Ledger("IDI");
        Status status = loanCommand.execute(ledger);

        Status expectedStatus = new Status(0,12);
        assertEquals(expectedStatus,status);
    }
}