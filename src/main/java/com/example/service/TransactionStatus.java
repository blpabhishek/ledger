package com.example.service;

import com.example.commands.BalanceCommandResult;
import com.example.commands.CommandResult;
import com.example.commands.CommandType;
import com.example.parser.Formatter;

import java.util.Objects;

public class TransactionStatus {
    private Exception error;
    private CommandResult cmdCommandResult;

    public TransactionStatus setResult(CommandResult commandResult) {
        this.cmdCommandResult = commandResult;
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
        if (this.cmdCommandResult != null && cmdCommandResult.isType(CommandType.BALANCE)) {
            BalanceCommandResult cmd = (BalanceCommandResult) this.cmdCommandResult;
            String result = String.format("%s %s %s", cmd.getBank(), cmd.getAmountPaid(), cmd.getNoOfEMIsLeft());
            formatter.println(result);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionStatus that = (TransactionStatus) o;
        return Objects.equals(error.getMessage(), that.error.getMessage())
                && Objects.equals(cmdCommandResult, that.cmdCommandResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, cmdCommandResult);
    }
}
