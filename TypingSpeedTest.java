import java.util.Random;
import java.util.Scanner;

public class TypingSpeedTest {
    // Array of random words
    private static final String[] words = {
        "the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog","english", "french",
        "dinosour", "envelope", "laptop", "inherit", "where", "ambulance", "restriction",
        "bottle", "carton", "curtain", "gylcerin", "hypocrisy", "calculation", "worship", "12", "&", "#", "5638", "!", "04621", "@", "632fbjd", "573924", "##", "++"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("-------------------------------------------SPEED TYPING TEST------------------------------------------");
        System.out.println(" ");
        Random random = new Random();
        
        // Generate a random sentence of 10 words
        StringBuilder sentence = new StringBuilder();
        System.out.print("Enter the sentence length you want: ");
        int nw = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nw; i++) {
            String randomWord = words[random.nextInt(words.length)];
            sentence.append(randomWord).append(" ");
        }
        String sentenceToType = sentence.toString().trim();

        System.out.println(" ");
        System.out.println("Type the following sentence:");
        System.out.println(sentenceToType);
        System.out.print("Press Enter when you are ready to start...");

        // Wait for user to press Enter
        scanner.nextLine();
    
        // Start the timer
        long startTime = System.currentTimeMillis();

        // Get user input
        String userInput = scanner.nextLine();

        // Stop the timer
        long endTime = System.currentTimeMillis();

        // Calculate time taken in seconds
        double timeTaken = (endTime - startTime) / 1000.0; // in seconds

        // Calculate words per minute (WPM)
        int wordCount = userInput.split("\\s+").length; // Count words
        double wpm = (wordCount / timeTaken) * 60; // Convert to WPM

        // Display results
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<< RESULTS >>>>>>>>>>>>>>>>>>>>>");
        System.out.println(" ");
        System.out.printf("Time taken: %.2f seconds\n", timeTaken);
        System.out.printf("Your typing speed: %.2f words per minute\n", wpm);

        // Check accuracy
        int correctCharacters = 0;
        for (int i = 0; i < Math.min(sentenceToType.length(), userInput.length()); i++) {
            if (sentenceToType.charAt(i) == userInput.charAt(i)) {
                correctCharacters++;
            }
        }

        double accuracy = (double) correctCharacters / sentenceToType.length() * 100;
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        scanner.close();

    }
}
 





