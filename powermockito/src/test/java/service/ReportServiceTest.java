package service;

import org.example.service.ReportService;
import org.example.utils.DateFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DateFormatter.class)
public class ReportServiceTest {

    @Test
    public void testGenerateReport_withMockedDate() {
        PowerMockito.mockStatic(DateFormatter.class);
        Mockito.when(DateFormatter.getCurrentDate()).thenReturn("2025-01-01");

        ReportService service = new ReportService();
        String result = service.generateReport();

        Assert.assertEquals("Report generated on 2025-01-01", result);
    }
}