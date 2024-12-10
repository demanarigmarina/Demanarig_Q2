import java.util.Scanner;

public class PowerLevelAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];

        // Input the Power Levels
        System.out.println("Enter the power levels of 10 creatures:");
        for (int i = 0; i < powerLevels.length; i++) {
            System.out.print("Power Level " + (i + 1) + ": ");
            powerLevels[i] = scanner.nextInt();
        }

        // Bubble Sort in Ascending Order
        int[] bubbleSorted = powerLevels.clone(); // Create a copy for sorting order
        bubbleSort(bubbleSorted);
        System.out.println("\nPower Levels Sorted in Ascending Order (Bubble Sort):");
        displayArray(bubbleSorted);

        // Selection Sort in Descending Order
        int[] selectionSorted = powerLevels.clone(); // Create a clone for sorting
        selectionSort(selectionSorted);
        System.out.println("\nPower Levels Sorted in Descending Order (Selection Sort):");
        displayArray(selectionSorted);

        // Calculation of the sum of odd and even numbers
        int sumEven = 0, sumOdd = 0;
        for (int power : powerLevels) {
            if (power % 2 == 0) {
                sumEven += power;
            } else {
                sumOdd += power;
            }
        }
        int min = findMin(powerLevels);
        int max = findMax(powerLevels);

        System.out.println("\nAnalysis:");
        System.out.println("Sum of Even Power Levels: " + sumEven);
        System.out.println("Sum of Odd Power Levels: " + sumOdd);
        System.out.println("Minimum Power Level: " + min);
        System.out.println("Maximum Power Level: " + max);
    }

    // Bubble Sort Algorithm for Ascending Order
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort Algorithm for Descending Order
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // This part find the maximum element in the unsorted portion
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap the found maximum with the first element of the unsorted portion
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
    }

    public static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // This part find Minimum Value in Array
    public static int findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Find Maximum Value in Array
    public static int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}