package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;

public class PaymentCommand implements Command {
    private final String bank;
    private final String name;
    private final int lumSumAmount;
    private final int emiTerms;

    public PaymentCommand(String bank, String name, int lumSumAmount, int emiTerms) {
        this.bank = bank;
        this.name = name;
        this.lumSumAmount = lumSumAmount;
        this.emiTerms = emiTerms;
    }

    @Override
    public Status execute(Ledger ledger) throws UnknownUserException {
        return ledger.payment(name, lumSumAmount, emiTerms);
    }

    @Override
    public String getBank() {
        return bank;
    }
}
