package com.vitorfurini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;


public class TransactionProcessorWOApacheCommons {

    public static void main(String[] args) {
        File file = new File("src/main/resources/files/csv/transaction.csv");

        //Manual validation (no Commons IO)
        if (!file.exists() || file.length() == 0) {
            System.err.println("No transaction file found or file is empty!");
            return;
        }

        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file, StandardCharsets.UTF_8))) {

            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                //Manual CSV parsing
                String[] columns = line.split(",", -1);
                if (columns.length < 3) continue;

                String customerId = columns[0].trim();
                String amountStr = columns[1].trim();
                String currency = columns[2].trim();

                double amount = parseAmount(amountStr);
                transactions.add(new Transaction(customerId, amount, currency));
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        //Manual summary
        DoubleSummaryStatistics stats = transactions.stream()
                .mapToDouble(Transaction::amount)
                .summaryStatistics();

        System.out.println("Transactions processed: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Avg: " + stats.getAverage());
    }

    private static double parseAmount(String value) {
        if (value == null || value.isBlank()) return 0.0;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    record Transaction(String customerId, double amount, String currency) {}
}
