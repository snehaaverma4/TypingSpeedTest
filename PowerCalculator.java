import java.util.Scanner;
class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative");
        }
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero");
        }
        return (long) Math.pow(n, p);
    }
}
public class PowerCalculator {
    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            try {
                long result = myCalculator.power(n, p);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("java.lang.Exception: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
