import java.util.Arrays;
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 5, 43, 78};
        System.out.println("Original Array: " + Arrays.toString(array));
        // Bubble Sort
        int[] bubbleSortedArray = array.clone();
        bubbleSort(bubbleSortedArray);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(bubbleSortedArray));
        // Selection Sort
        int[] selectionSortedArray = array.clone();
        selectionSort(selectionSortedArray);
        System.out.println("Selection Sorted Array: " + Arrays.toString(selectionSortedArray));
        // Insertion Sort
        int[] insertionSortedArray = array.clone();
        insertionSort(insertionSortedArray);
        System.out.println("Insertion Sorted Array: " + Arrays.toString(insertionSortedArray));
    }
    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // Selection Sort Algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
