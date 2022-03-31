package com.example.domain;

import java.util.HashMap;

public class Ledger {
    HashMap<String, LoanCalculator> transactions = new HashMap<String, LoanCalculator>();

    public void addLoan(String name, LoanCalculator loanCalculator) {
        transactions.put(name,loanCalculator);
    }

    public int count() {
        return transactions.size();
    }

    public Status getBalance(String name, int terms) {
        //TODO throw Exception for not found
        LoanCalculator loanCalculator = transactions.getOrDefault(name,new LoanCalculator(0,1,0));
        return new Status(loanCalculator.amountPaid(terms), loanCalculator.remainingEMI(terms));
    }
}
