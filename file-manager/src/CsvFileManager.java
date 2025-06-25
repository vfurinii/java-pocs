import java.io.*;
import java.util.Arrays;

public class CsvFileManager {

    public static void main(String[] args) throws IOException {
        String fileName = "file-manager/resources/files/report.csv";

        //write csv file
        writeCsv(fileName);

        //read csv file
        readCsv(fileName);

        //delte csv file
        //deleteFile(fileName);
    }

    private static void writeCsv(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //file header
            writer.write("ID, Name, Email");
            writer.newLine();

            //content
            String[] names = {
                    "Vitor", "Gabi", "Bernardo", "Laura", "Lucas", "Mariana", "Felipe", "Ana", "João", "Camila",
                    "Pedro", "Bianca", "Matheus", "Isabela", "Rafael", "Sofia", "Gustavo", "Clara", "Leonardo", "Julia",
                    "Diego", "Manuela", "Henrique", "Livia", "Eduardo", "Beatriz", "Bruno", "Lara", "André", "Fernanda",
                    "Caio", "Carla", "Igor", "Paula", "Rodrigo", "Renata", "Thiago", "Patricia", "Alex", "Leticia",
                    "Daniel", "Catarina", "Marcelo", "Tais", "Samuel", "Helena", "Vinicius", "Luana", "Fernando", "Yasmin"
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


    private static void readCsv(String fileName) {
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

    private static void deleteFile(String fileName) {
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