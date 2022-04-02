package com.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ledgers {

    private final List<Ledger> banks = new ArrayList<>();

    public Ledger getLedger(String bank) {
        Optional<Ledger> optionalLedger = banks.stream()
                .filter((x) -> x.isSameBank(bank))
                .findAny();
        if (optionalLedger.isEmpty()) {
            Ledger ledger = new Ledger(bank);
            banks.add(ledger);
            return ledger;
        }
        return optionalLedger.get();
    }

}
