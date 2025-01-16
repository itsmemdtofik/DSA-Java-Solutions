import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class SelectionSort {
    public static int[] _f_SelectionSort(int arr[]) {

        for (int i = 0; i < (arr.length - 1); i++) {
            int min = i;

            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
        return arr;
    }

    public static void main(String[] args) {
      runTestCases();
    }

    public static void runTestCases() {
        List<int[]> testCases = new ArrayList<>();

        // Adding complex test cases
        testCases.add(new int[] {}); 
        testCases.add(new int[] {1}); 
        testCases.add(new int[] {2, 1});
        testCases.add(new int[] {1, 2});
        testCases.add(new int[] {10,16,8,12,15,6,3,9,5,100}); 
        testCases.add(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        testCases.add(new int[] {8, 7, 6, 5, 4, 3, 2, 1});
        testCases.add(new int[] {4, 2, 2, 8, 3, 3, 1});

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
            int[] sorted = SelectionSort._f_SelectionSort(testCase.clone());
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
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
