package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Loan;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentsCommandTest {
    @Test
    void shouldBeAbleToPayForAnExistingLoan() throws UnknownUserException {
        PaymentCommand paymentCommand = new PaymentCommand("IDI", "Bob", 5000, 0);
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("Bob", new Loan(12000, 1, 0));
        CommandResult commandResult = paymentCommand.execute(ledger);

        CommandResult expectedCommandResult = new CommandResult("IDI", 5000, 7);
        assertEquals(expectedCommandResult, commandResult);
    }

    @Test
    void shouldNotAcceptPaymentForUnknownUser() {
        PaymentCommand paymentCommand = new PaymentCommand("IDI", "Bob", 1000, 0);
        Ledger ledger = new Ledger("IDI");

        assertThrows(UnknownUserException.class,()->paymentCommand.execute(ledger));
    }
}
