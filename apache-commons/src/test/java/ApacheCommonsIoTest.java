import com.vitorfurini.CommonsIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApacheCommonsIoTest {

    private File exampleFile;
    private File copyFile;
    private FileAlterationMonitor monitor;

    @BeforeEach
    void setup() throws Exception {
        exampleFile = new File("example.txt");
        copyFile = new File("copy.txt");
        FileUtils.writeStringToFile(exampleFile, "Hello from Apache Commons IO!\n", StandardCharsets.UTF_8);
        monitor = CommonsIO.getFileAlterationMonitor();
    }

    @AfterEach
    void cleanup() throws Exception {
        if (exampleFile.exists()) {
            exampleFile.delete();
        }
        if (copyFile.exists()) {
            copyFile.delete();
        }
        if (monitor != null) {
            try {
                monitor.stop();
            } catch (IllegalStateException e) {
                // Monitor was not started, ignore
            }
        }
    }

    @Test
    @DisplayName("Read file content successfully")
    void readFileContentSuccessfully() throws Exception {
        String content = FileUtils.readFileToString(exampleFile, StandardCharsets.UTF_8);
        assertEquals("Hello from Apache Commons IO!\n", content);
    }

    @Test
    @DisplayName("Copy file content successfully")
    void copyFileContentSuccessfully() throws Exception {
        try (FileInputStream in = new FileInputStream(exampleFile);
             FileOutputStream out = new FileOutputStream(copyFile)) {
            IOUtils.copy(in, out);
        }
        assertTrue(copyFile.exists());
        String copiedContent = FileUtils.readFileToString(copyFile, StandardCharsets.UTF_8);
        assertEquals("Hello from Apache Commons IO!\n", copiedContent);
    }

    @Test
    @DisplayName("Monitor detects file creation")
    void monitorDetectsFileCreation() throws Exception {
        monitor.start();
        File newFile = new File("newFile.txt");
        newFile.createNewFile();
        Thread.sleep(4000); // Wait for monitor to detect changes
        assertTrue(newFile.exists());
        newFile.delete();
    }

    @Test
    @DisplayName("Monitor detects file deletion")
    void monitorDetectsFileDeletion() throws Exception {
        monitor.start();
        exampleFile.delete();
        Thread.sleep(4000); // Wait for monitor to detect changes
        assertTrue(!exampleFile.exists());
    }

    @Test
    @DisplayName("Monitor detects file modification")
    void monitorDetectsFileModification() throws Exception {
        monitor.start();
        FileUtils.writeStringToFile(exampleFile, "Modified content", StandardCharsets.UTF_8, true);
        Thread.sleep(4000); // Wait for monitor to detect changes
        String modifiedContent = FileUtils.readFileToString(exampleFile, StandardCharsets.UTF_8);
        assertTrue(modifiedContent.contains("Modified content"));
    }
}
