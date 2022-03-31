package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    void shouldCalculateTotalLoanAmountUsingSimpleInterest() {
        Loan calc = new Loan(10000, 5, 4);
        long amount = calc.totalAmount();

        assertEquals(12000, amount);
    }

    @Test
    void shouldCalculateMonthlyEMITobePaid() {
        Loan calc = new Loan(10000, 5, 4);
        long emi = calc.monthlyEMI();

        assertEquals(200, emi);
    }

    @Test
    void shouldRoundOffAndCalculateMonthlyEMITobePaid() {
        Loan calc = new Loan(2000, 2, 2);
        long emi = calc.monthlyEMI();

        assertEquals(87, emi);
    }

    @Test
    void shouldGetRemainingBalanceAfterTheNumberOfEMIsBeenPaid() {
        Loan calc = new Loan(2000, 2, 2);
        long outstanding = calc.remainingAmount(4);

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
