package org.java;

import java.io.*;
public class Main {

    private static final String CSV_FILE = "file.csv";
    public static void main(String[] args) {
        writeCSV();
        readCSV();
        }

        // csv generate
        private static void writeCSV() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
                writer.write("name,age,email");
                writer.newLine();
                writer.write("Vitor,30,vitor@email.com");
                writer.newLine();
                writer.write("Gabriela,29,gabriela@email.com");
                writer.newLine();
                writer.write("Bernardo,12,bernardo@email.com");
                writer.newLine();
                writer.newLine();
                writer.write("Vicenzo,9,vicenzo@email.com");
                System.out.println("CSV file created successfully: " + CSV_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Leitura do CSV
        private static void readCSV() {
            System.out.println("\ncsv content:");
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");
                    System.out.printf("Name: %s, age: %s, email: %s%n",
                            columns[0], columns[1], columns[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }