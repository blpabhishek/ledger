package com.example;

import com.example.domain.Ledgers;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;
import com.example.parser.Command;
import com.example.parser.InputParser;
import com.example.service.LedgerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, UnknownUserException {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        List<String> fileContent = Files.readAllLines(Path.of("src/main/resources/transactions-1.txt"));
        for (String line : fileContent) {
            InputParser inputParser = new InputParser();
            Command command = inputParser.parse(line);
            Status status = ledgerService.execute(command);
            System.out.println(status);
        }
    }

}