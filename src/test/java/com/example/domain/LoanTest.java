package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    void shouldCalculateTotalLoanAmountUsingSimpleInterest() {
        Loan loan = new Loan(10000, 5, 4);
        long amount = loan.totalAmount();

        assertEquals(12000, amount);
    }

    @Test
    void shouldCalculateMonthlyEMITobePaid() {
        Loan loan = new Loan(10000, 5, 4);
        long emi = loan.monthlyEMI();

        assertEquals(200, emi);
    }

    @Test
    void shouldRoundOffAndCalculateMonthlyEMITobePaid() {
        Loan loan = new Loan(2000, 2, 2);
        long emi = loan.monthlyEMI();

        assertEquals(87, emi);
    }

    @Test
    void shouldGetRemainingBalanceAfterTheNumberOfEMIsBeenPaid() {
        Loan loan = new Loan(2000, 2, 2);
        long outstanding = loan.remainingAmount(4);

        assertEquals(1732, outstanding);
    }

    @Test
    void shouldGetRemainingNumberOfEMIsToBePaid() {
        Loan loan = new Loan(2000, 2, 2);
        int remainingEMIs = loan.remainingEMI(4);

        assertEquals(20, remainingEMIs);
    }

    @Test
    void shouldGetPaidAmount() {
        Loan loan = new Loan(2000, 2, 2);
        long amountPaid = loan.amountPaid(4);

        assertEquals(348, amountPaid);
    }
}
