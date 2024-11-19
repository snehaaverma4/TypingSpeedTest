import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileCopyAndCount {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileCopyAndCount <sourceFile> <destinationFile>");
            return;
        }
        String sourceFile = args[0];
        String destinationFile = args[1];
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, '&');
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Number of occurrences of '&': " + count);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the files: " + e.getMessage());
        }
    }
    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }
}
