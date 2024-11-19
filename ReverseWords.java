import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int numberOfSentences = scanner.nextInt();
        scanner.nextLine(); 
        List<String> sentences = new ArrayList<>();
        System.out.println("Enter the sentences:");
        for (int i = 0; i < numberOfSentences; i++) {
            String sentence = scanner.nextLine();
            sentences.add(sentence);
        }
        List<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            String[] splitWords = sentence.replaceAll("[',.;:]", "").split("\\s+");
            for (String word : splitWords) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.print(words.get(i) + " ");
        }
        scanner.close();
    }
}
