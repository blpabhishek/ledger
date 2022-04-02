package com.example;

import com.example.commands.Command;
import com.example.commands.InvalidCommandException;
import com.example.domain.Ledgers;
import com.example.parser.InputParser;
import com.example.service.LedgerService;
import com.example.service.TransactionStatus;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCommandException {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        PrintStream consoleFormatter = System.out;
        List<String> fileContent = Files.readAllLines(Path.of("src/main/resources/transactions-2.txt"));
        for (String line : fileContent) {
            Command command = InputParser.parse(line);
            TransactionStatus transactionStatus = ledgerService.execute(command);
            transactionStatus.print(consoleFormatter);
        }
    }

}