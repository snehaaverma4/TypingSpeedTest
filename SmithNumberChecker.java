import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmithNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check if the number is a Smith number
        if (isSmithNumber(number)) {
            System.out.println(number + " is a SMITH Number.");
        } else {
            System.out.println(number + " is NOT a SMITH Number.");
        }
        
        scanner.close();
    }

    // Method to check if a number is a Smith number
    public static boolean isSmithNumber(int number) {
        // A Smith number must be composite
        if (!isComposite(number)) {
            return false;
        }
        
        int digitSum = sumOfDigits(number);
        List<Integer> primeFactors = primeFactorization(number);
        int factorDigitSum = sumOfFactorDigits(primeFactors);
        
        return digitSum == factorDigitSum;
    }

    // Method to check if a number is composite
    public static boolean isComposite(int number) {
        if (number < 4) return false; // 0, 1, 2, 3 are not composite
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return true; // Found a divisor, hence composite
            }
        }
        return false; // No divisors found, hence prime
    }

    // Method to calculate the sum of the digits of a number
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Method to perform prime factorization and return the prime factors
    public static List<Integer> primeFactorization(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        return factors;
    }

    // Method to calculate the sum of the digits of the prime factors
    public static int sumOfFactorDigits(List<Integer> factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += sumOfDigits(factor);
        }
        return sum;
    }
}
