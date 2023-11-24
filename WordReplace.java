import java.io.*;

public class WordReplace {
    public static void main(String[] args) {
        String sourceFileName = "ahmad.txt"; 
        String destinationFileName = "modified.txt"; 
        String searchWord = "soon"; 
        String replaceWord = "one day"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                
                String modifiedLine = line.replaceAll(searchWord, replaceWord);
                writer.write(modifiedLine);
                writer.newLine(); 
            }

            System.out.println("Word replaced and content saved to " + destinationFileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
