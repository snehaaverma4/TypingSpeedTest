import java.util.Arrays;
import java.util.Scanner;
public class PendulumArrangement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int[] pendulumArray = new int[n];
        int mid = n / 2;
        pendulumArray[mid] = array[0];
        int left = mid - 1;
        int right = mid + 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                pendulumArray[left] = array[i];
                left--;
            } else {
                pendulumArray[right] = array[i];
                right++;
            }
        }
        System.out.println("Pendulum Arrangement: " + Arrays.toString(pendulumArray));
        scanner.close();
    }
}
