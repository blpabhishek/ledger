package com.example;

import com.example.parser.Command;
import com.example.parser.InputParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileContent = Files.readAllLines(Path.of("src/main/resources/transactions-1.txt"));
        for (String line : fileContent) {
            InputParser inputParser = new InputParser();
            Command command = inputParser.parse(line);
            // create ledger service
            // apply commands on ledger service
            // get the result and show the response
        }
    }

}