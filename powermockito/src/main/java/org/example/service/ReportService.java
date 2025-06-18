package org.example.service;

import org.example.utils.DateFormatter;

public class ReportService {
    public String generateReport() {
        return "report generated on " + DateFormatter.getCurrentDate();
    }
}
