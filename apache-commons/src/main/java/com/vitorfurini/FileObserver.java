package com.vitorfurini;
import org.apache.commons.io.monitor.*;

import java.io.File;

public class FileObserver {

    // monitors the /tmp directory for new files every 5 seconds and prints the name of any new file created
    public void observeFile() throws Exception {
        FileAlterationObserver observer = new FileAlterationObserver("/tmp");
        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("file created: " + file.getName());
            }
        });

        FileAlterationMonitor monitor = new FileAlterationMonitor(5000, observer);
        monitor.start();
    }
}
