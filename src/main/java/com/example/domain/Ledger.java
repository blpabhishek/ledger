package com.example.domain;

import java.util.HashMap;

public class Ledger {
    HashMap<String, Loan> transactions = new HashMap<String, Loan>();

    public void addLoan(String name, Loan loan) {
        transactions.put(name, loan);
    }

    public int count() {
        return transactions.size();
    }

    public Status getBalance(String name, int terms) {
        //TODO throw Exception for not found
        Loan loan = transactions.getOrDefault(name,new Loan(0,1,0));
        return new Status(loan.amountPaid(terms), loan.remainingEMI(terms));
    }
}
