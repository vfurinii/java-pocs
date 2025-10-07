package com.vitorfurini;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CommonsIO {

    public void readFile() throws Exception {

        File file = getFile();

        //read an entire file in one line
        String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        
        System.out.println("File content:");
        System.out.println(content);

        //cp contents using IOUtils
        try (InputStream in = new FileInputStream("example.txt");
             OutputStream out = new FileOutputStream("copy.txt")) {

            //copy one stream into another
            IOUtils.copy(in, out);
        }
        System.out.println("File copied to copy.txt");

        //monitor a directory for changes
        FileAlterationMonitor monitor = getFileAlterationMonitor();
        monitor.start();

        System.out.println("Monitoring current directory... (press Ctrl+C to exit)");

        //keep the program running to observe file changes
        Thread.sleep(Long.MAX_VALUE);
    }

    private static File getFile() throws IOException {
        File file = new File("example.txt");
        FileUtils.writeStringToFile(file, "Hello from Apache Commons IO!\n", StandardCharsets.UTF_8);
        return file;
    }

    public static FileAlterationMonitor getFileAlterationMonitor() {
        File directoryToWatch = new File(".");
        FileAlterationObserver observer = new FileAlterationObserver(directoryToWatch);

        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("file created: " + file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("file deleted: " + file.getName());
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("file changed: " + file.getName());
            }
        });

        return new FileAlterationMonitor(3000, observer);
    }
}
