package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalculatorTest {
    @Test
    void shouldCalculateTotalLoanAmountUsingSimpleInterest() {
        LoanCalculator calc = new LoanCalculator(10000, 5, 4);
        long amount = calc.totalAmount();

        assertEquals(12000, amount);
    }

    @Test
    void shouldCalculateMonthlyEMITobePaid() {
        LoanCalculator calc = new LoanCalculator(10000, 5, 4);
        long emi = calc.monthlyEMI();

        assertEquals(200, emi);
    }

    @Test
    void shouldRoundOffAndCalculateMonthlyEMITobePaid() {
        LoanCalculator calc = new LoanCalculator(2000, 2, 2);
        long emi = calc.monthlyEMI();

        assertEquals(87, emi);
    }

    @Test
    void shouldGetRemainingBalanceAfterTheNumberOfEMIsBeenPaid() {
        LoanCalculator calc = new LoanCalculator(2000, 2, 2);
        long outstanding = calc.remainingAmount(4);

        assertEquals(1732, outstanding);
    }

    @Test
    void shouldGetRemainingNumberOfEMIsToBePaid() {
        LoanCalculator loanCalculator = new LoanCalculator(2000, 2, 2);
        int remainingEMIs = loanCalculator.remainingEMI(4);

        assertEquals(20, remainingEMIs);
    }

    @Test
    void shouldGetPaidAmount() {
        LoanCalculator loanCalculator = new LoanCalculator(2000, 2, 2);
        long amountPaid = loanCalculator.amountPaid(4);

        assertEquals(348, amountPaid);
    }
}
