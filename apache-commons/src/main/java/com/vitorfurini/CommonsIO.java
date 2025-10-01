package com.vitorfurini;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommonsIO {

    public void readFile() throws IOException {

        File file = new File("example.txt");
        String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
