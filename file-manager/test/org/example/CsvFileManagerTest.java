package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsvFileManagerTest {

    private final String testFileName = "test_output.csv";

    @Before
    public void setUp() throws Exception {
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @After
    public void tearDown() throws Exception {
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void writeCsvCreatesFileWithCorrectContent() throws IOException {
        CsvFileManager.writeCsv(testFileName);

        File file = new File(testFileName);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("ID, Name, Email", reader.readLine());
            assertEquals("1, Vitor, vitor@email.com", reader.readLine());
        }
    }

    @Test
    public void writeCsvHandlesEmptyFileNameGracefully() {
        try {
            CsvFileManager.writeCsv("");
        } catch (IOException e) {
            assertEquals("File name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void writeCsvHandlesInvalidFilePath() {
        try {
            CsvFileManager.writeCsv("/invalid/path/output.csv");
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("Error writing CSV"));
        }
    }
}