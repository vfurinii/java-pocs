package org.vitorfurini.hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.io.FileMatchers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileMatcher {
    public static void main(String[] args) {

        File file = new File("example.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            //criando um array de bytes com tamanho 1024 (1 KB)
            byte[] data = new byte[1024];
            Arrays.fill(data, (byte) 0); //preenche com zeros

            // Escrevendo no arquivo
            fos.write(data);
            fos.flush();

            System.out.println("arquivo criado: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File directory = new File("C:\\Users\\vitor\\IdeaProjects\\java-pocs\\hamcrest\\src\\main\\java\\org\\vitorfurini\\hamcrest\\");

        //verify if file exists
        MatcherAssert.assertThat(file, FileMatchers.anExistingFile());
        //verify if the directory exists
        MatcherAssert.assertThat(directory, FileMatchers.anExistingDirectory());
        //verify the file is readable
        MatcherAssert.assertThat(file, FileMatchers.aReadableFile());
        //verify the file is writable
        MatcherAssert.assertThat(file, FileMatchers.aWritableFile());
        //verify the file has a specific size (e.g., 1024 bytes)
        MatcherAssert.assertThat(file, FileMatchers.aFileWithSize(1024L));
    }
}
