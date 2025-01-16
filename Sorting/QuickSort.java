import java.lang.Math;
import java.util.*;

class QuickSortClass {

    public static int _f_Partition(int arr[], int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = arr[low]; // Use the first element to pivot

        while (i <= j) {
            do {
                i++;
            } while (i <= high && arr[i] <= pivot); // Ensure i doesn't exceed high

            do {
                j--;
            } while (j >= low && arr[j] > pivot); // Ensure j doesn't go below low

            /**
             * This swapping is for arranging the elements which are lesser than pivot.
             * And also the elements which are greater than pivot.
             * The elements which are greater than pivot will come on the right side.
             * The elements which are smaller than pivot will come on the left side.
             * Swap elements at i and j
             */
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        /**
         * This swapping is for finding the pivot element and exchanging it with the j
         * position element.
         * Swap pivot with arr[j] so that pivot is in its correct position.
         */
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j; // Return the index of the pivot element
    }

    public static int[] _f_QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int j = _f_Partition(arr, low, high);// Partition the array
            _f_QuickSort(arr, low, (j - 1)); // Recursively Sort the left side
            _f_QuickSort(arr, (j + 1), high); // Recursively Sort the right side
        }
        return arr;
    }

    public static void runTestCases() {
        List<int[]> testCases = new ArrayList<>();

        // Adding complex test cases
        testCases.add(new int[] { 2, 7, 1, 15, 5, 20, 40 }); // Empty array
        testCases.add(new int[] { 1 }); // Single element
        testCases.add(new int[] { 2, 1 }); // Two elements unsorted
        testCases.add(new int[] { 1, 2 }); // Two elements sorted
        testCases.add(new int[] { 10, 16, 8, 12, 15, 6, 3, 9, 5, 100 }); // Random unsorted array
        testCases.add(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }); // Already sorted array
        testCases.add(new int[] { 8, 7, 6, 5, 4, 3, 2, 1 }); // Reverse sorted array
        testCases.add(new int[] { 4, 2, 2, 8, 3, 3, 1 }); // Array with duplicates

        // Generating additional complex test cases dynamically
        for (int i = 0; i < 92; i++) {
            int size = (int) (Math.random() * 100) + 10; // Random size between 10 and 100
            int[] randomArray = new int[size];
            for (int j = 0; j < size; j++) {
                randomArray[j] = (int) (Math.random() * 1000) - 500; // Random numbers between -500 and 499
            }
            testCases.add(randomArray);
        }

        // Running all test cases
        int testCaseNumber = 1;
        for (int[] testCase : testCases) {
            System.out.println("Test Case " + testCaseNumber + ":");
            System.out.println("Input: " + Arrays.toString(testCase));
            int[] sorted = QuickSortClass._f_QuickSort(testCase.clone(), 0, testCase.length - 1);
            System.out.println("Output: " + Arrays.toString(sorted));

            // Validate if the output is sorted
            if (isSorted(sorted)) {
                System.out.println("Result: Pass\n");
            } else {
                System.out.println("Result: Fail\n");
            }

            testCaseNumber++;
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

}

public class QuickSort {
    public static void main(String[] args) {

        QuickSortClass.runTestCases();
        System.out.println();
        System.out.println("---------------------------------------------\n");

    }

}
