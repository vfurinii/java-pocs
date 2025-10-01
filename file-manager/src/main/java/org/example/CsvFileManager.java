package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CsvFileManager {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/vfurini/Documents/output.csv";

        //write csv file
        //writeCsv(fileName);

        //read csv file
        //readCsv(fileName);

        //edit csv file
        //editCsv(fileName);

        //zip file
        //zipCsv(fileName);

        //unzip file
//        unzipCsv(fileName.replace(".csv", ".zip"));

        //delte csv file
        //deleteFile(fileName);
    }

    public static void writeCsv(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //file header
            writer.write("ID, Name, Email");
            writer.newLine();

            //content
            String[] names = {
                    "John", "Doe", "Gremio"
            };

            //method to generate IDs and emails using name in array + @email
                for (int i = 0; i < names.length; i++) {
                    String id = String.valueOf(i + 1);
                    String name = names[i];
                    String email = name.toLowerCase() + "@email.com";

                    writer.write(id + ", " + name + ", " + email);
                    writer.newLine();

                }
                System.out.println("CSV file created: " + fileName);

            } catch (IOException e) {
                System.err.println("Error writing CSV: " + e.getMessage());
            }
        }


    public static void readCsv(String fileName) {
        System.out.println("\nReading CSV content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // splitterator default
                String[] columns = line.split(",");
                System.out.println(Arrays.toString(columns));
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }

    public static void editCsv(String fileName) {
        String outputFile = "/Users/vfurini/Documents/output_1.csv";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
             BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFile))) {

            String line;
            String prevLine = null;
            while ((line = br.readLine()) != null) {
                int idx = line.indexOf("_");
                if (idx != -1) {
                    line = line.substring(0, idx);
                }if (line.equals(prevLine)) {
                    continue;
                }
                bw.write(line);
                bw.newLine();
                prevLine = line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipCsv(String fileName) {
        System.out.println("\nZipping CSV file: " + fileName);
        String zipFileName = fileName.replace(".csv", ".zip");
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(zipFileName);
             java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(fos)) {

            zos.putNextEntry(new java.util.zip.ZipEntry(new File(fileName).getName()));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
            System.out.println("CSV file zipped: " + zipFileName);

        } catch (IOException e) {
            System.err.println("Error zipping CSV: " + e.getMessage());
        }
    }

    public static void unzipCsv(String replace) throws IOException {
        File destDir = new File("file-manager/resources/unzipedFile");

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(replace)));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    public static void deleteFile(String fileName) {
        System.out.println("\nSearching CSV file: " + fileName);
        File fileToDelete = new File(fileName);
        if (fileToDelete.exists()) {
            fileToDelete.delete();
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File does not exist.");
        }
    }
}