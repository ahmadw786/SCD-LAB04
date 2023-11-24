

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        String fileName = "ahmad.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                
                String[] words = line.split("\\s+");
                wordCount += words.length;

                
                System.out.println(line);
            }

            System.out.println("Total words in the file: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
