package com.example.service;

import com.example.commands.CommandResult;
import com.example.parser.Formatter;

import java.util.Objects;

public class TransactionStatus {
    private Exception error;
    private CommandResult cmdResult;

    public TransactionStatus setResult(CommandResult commandResult) {
        this.cmdResult = commandResult;
        return this;
    }

    public TransactionStatus setError(Exception e) {
        this.error = e;
        return this;
    }

    public void print(Formatter formatter) {
        if (this.error != null) {
            formatter.println(error.getMessage());
        }
        if (this.cmdResult != null && this.cmdResult.isBalanceCommand()) {
            String result = String.format("%s %s %s", cmdResult.getBank(), cmdResult.getAmountPaid(), cmdResult.getNoOfEMIsLeft());
            formatter.println(result);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionStatus that = (TransactionStatus) o;
        return Objects.equals(cmdResult, that.cmdResult);
    }
}
