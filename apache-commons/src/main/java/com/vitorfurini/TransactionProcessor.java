package com.vitorfurini;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class TransactionProcessor {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/files/csv/transaction.csv");

        //not using commons IO
        if (!file.exists() || file.length() == 0) {
            System.err.println("No transaction file found or file is empty!");
            return;
        }

        //safely reads the entire file content
        String csvContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        //commons CSV
        try (CSVParser parser = CSVParser.parse(csvContent, CSVFormat.DEFAULT
                .withHeader("CustomerId", "Amount", "Currency")
                .withSkipHeaderRecord(true))) {

            List<CSVRecord> records = parser.getRecords();

            DoubleSummaryStatistics stats = records.stream()
                    .mapToDouble(record -> {
                        String amountStr = StringUtils.trimToEmpty(record.get("Amount"));
                        return parseAmount(amountStr);
                    })
                    .summaryStatistics();

            System.out.println("Transactions processed: " + stats.getCount());
            System.out.println("min: " + stats.getMin());
            System.out.println("max: " + stats.getMax());
            System.out.println("AVg: " + stats.getAverage());

        } catch (Exception e) {
            System.err.println("error parsing CSV: " + e.getMessage());
        }
    }

    //commons Lang: null-safe string validation
    private static double parseAmount(String value) {
        if (StringUtils.isBlank(value)) return 0.0;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0; //Defensive fallback
        }
    }
}
