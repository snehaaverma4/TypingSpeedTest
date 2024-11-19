import java.util.Scanner;
class Distance {
    private int f1, inc1; 
    private int f2, inc2; 
    public Distance(int a, int b, int c, int d) {
        this.f1 = a;
        this.inc1 = b;
        this.f2 = c;
        this.inc2 = d;
    }
    public void showDistance() {
        System.out.println("Distance 1: " + f1 + " feet " + inc1 + " inches");
        System.out.println("Distance 2: " + f2 + " feet " + inc2 + " inches");
    }
    public void sumDistance() {
        int totalInches = (inc1 + inc2);
        int totalFeet = (f1 + f2) + (totalInches / 12); 
        totalInches = totalInches % 12;
        System.out.println("Sum of Distances: " + totalFeet + " feet " + totalInches + " inches");
    }
}
public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first distance (feet inches): ");
        int feet1 = scanner.nextInt();
        int inches1 = scanner.nextInt();
        System.out.print("Enter second distance (feet inches): ");
        int feet2 = scanner.nextInt();
        int inches2 = scanner.nextInt();
        Distance distance = new Distance(feet1, inches1, feet2, inches2);
        distance.showDistance();
        distance.sumDistance();
        scanner.close();
    }
}
