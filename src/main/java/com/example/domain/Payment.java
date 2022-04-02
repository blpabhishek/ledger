package com.example.domain;

public class Payment {
    private final int afterEmiTerms;
    private final long lumSumAmount;

    public Payment(int afterEmiTerms, long lumSumAmount) {
        this.afterEmiTerms = afterEmiTerms;
        this.lumSumAmount = lumSumAmount;
    }

    public boolean greaterThan(int terms) {
        return terms>=afterEmiTerms;
    }

    public Long amount() {
        return lumSumAmount;
    }
}
