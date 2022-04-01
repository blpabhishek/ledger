package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LedgerTest {
    @Test
    void ledgerShouldRecordTheTransaction() {
        Ledger ledger = new Ledger("MBI");
        ledger.addLoan("name", new Loan(200, 2, 2));

        assertEquals(1,ledger.count());
    }
    @Test
    void ledgerShouldGiveTheStatusForTheGivenUser() {
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("name", new Loan(2000, 2, 2));
        Status status = ledger.getBalance("name",8);

        int amountPaid = 696;
        int noOfEMIsLeft = 16;
        Status expectedStatus = new Status(amountPaid, noOfEMIsLeft);

        assertEquals(expectedStatus,status);
    }
}
