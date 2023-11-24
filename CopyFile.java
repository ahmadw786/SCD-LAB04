

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String sourceFileName = "file1.txt"; 
        String destinationFileName = "file2.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                
                writer.write(line);
                writer.newLine(); 
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
