import java.util.Scanner;

public class DisariumNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check if the number is a Disarium number
        if (isDisarium(number)) {
            System.out.println(number + " is a Disarium number.");
        } else {
            System.out.println(number + " is not a Disarium number.");
        }
        
        scanner.close();
    }

    // Method to check if a number is a Disarium number
    public static boolean isDisarium(int number) {
        int sum = 0;
        int temp = number;
        int length = String.valueOf(number).length(); // Get the number of digits
        
        // Calculate the sum of digits powered with their respective positions
        for (int i = length; i >= 1; i--) {
            int digit = temp % 10; 
            sum += Math.pow(digit, i); 
            temp /= 10; 
        }
        
        // Check if the sum is equal to the original number
        return sum == number;
    }
}
