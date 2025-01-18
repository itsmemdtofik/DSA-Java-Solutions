import java.util.*;

public class MergingTwoArray {
    public static int[] mergearr(int arr1[], int arr2[]) {

        if (arr1.length == 0 && arr2.length == 0) {
            return new int[] {};
        }

        int n = arr1.length;
        int m = arr2.length;
        int merged[] = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j] || arr1[i] == arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }

        while (j < m) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void runTestCases() {
        // Method to run test cases

        // Define test cases as a 2D array (input arrays and expected output arrays)
        Object[][] testCases = {
                { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7 } },
                { new int[] { 5, 6, 7 }, new int[] { 1, 2, 3 }, new int[] { 1, 2, 3, 5, 6, 7 } },
                { new int[] { 1 }, new int[] {}, new int[] { 1 } },
                { new int[] { 1 }, new int[] { 2 }, new int[] { 1, 2 } },
                { new int[] {}, new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 } },
                { new int[] { 4, 5 }, new int[] {}, new int[] { 4, 5 } },
                { new int[] { 10 }, new int[] { 20, 30 }, new int[] { 10, 20, 30 } },
                { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5, 6 } },
                { new int[] { 1, 3 }, new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 } },
                { new int[] { 5, 6 }, new int[] { 7, 8 }, new int[] { 5, 6, 7, 8 } }
        };

        boolean allTestsPassed = true; // Flag to track if all tests pass
        int failedTestCount = 0; // Track the number of failed tests

        // Run through all test cases
        for (int i = 0; i < testCases.length; i++) {
            Object[] testCase = testCases[i];
            int[] arr1 = (int[]) testCase[0];
            int[] arr2 = (int[]) testCase[1];
            int[] expected = (int[]) testCase[2];

            // Call the mergeArr method to get the result
            int[] result = mergearr(arr1, arr2);

            // Compare the result with the expected output
            if (!Arrays.equals(result, expected)) {
                // If the test case fails, print detailed information
                failedTestCount++;
                System.out.println("Test case " + (i + 1) + " failed:");
                System.out.println("arr1: " + Arrays.toString(arr1));
                System.out.println("arr2: " + Arrays.toString(arr2));
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("Got: " + Arrays.toString(result));
                System.out.println("------------------------------");
                allTestsPassed = false; // Mark flag as false if any test fails
            }
        }

        // After running all test cases, print the final result
        if (allTestsPassed) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed. Total failed: " + failedTestCount);
        }

    }

    public static void main(String[] args) {

        runTestCases();
    }
}
