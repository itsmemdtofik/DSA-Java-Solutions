package Easy;

import java.util.Arrays;

/**
 * * Maximum Consecutive one's or zero in binary array.
 * Given a binary array, find the count of a maximum number of consecutive 1s
 * present in the array.
 * 
 * Examples :
 * 
 * Input: arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}
 * Output: 4
 * Explanation: The maximum number of consecutive 1’s in the array is 4 from
 * index 8-11.
 * 
 * 
 * Input: arr[] = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
 * Output: 1
 * Explanation: The maximum number of consecutive 0’s in the array is 1 from
 * index 0-1.
 * 
 */
public class MaximumConecutiveOne {

    public static int maximumconsecutive(int arr[]) {

        if (arr.length < 0) {
            return Integer.MIN_VALUE;
        }
        int countOne = 0;

        for (int i : arr) {
            if (i == 1) {
                countOne++;
            } else {
                countOne = 0;
            }
        }

        return countOne;

    }

    public static int maximumonerepeat(int arr[]) {
        int count = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        runTestCases();
    }

    public static void runTestCases() {

        int testCases[][] = {
                { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {},
        };

        int[] expectedResult = {
                1,
                4,
                0,
                1
        };

        boolean allTestsPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            int arr[] = testCases[i];
            int expected = expectedResult[i];
            int result = maximumconsecutive(arr);

            boolean passed = result == expected;
            if (passed) {
                System.out.println("Test Case " + (i + 1) + " - Arrays: " + Arrays.toString(arr)
                        + " Count One's is: " + result + " - Passed");
            } else {
                System.out.println("Test Case " + (i + 1) + " - Arrays: " + Arrays.toString(arr)
                        + " Count One's is: " + result + " - Failed (Expected: " + expected + ")");
                allTestsPassed = false; // Set flag to false if any test case fails
            }

        }

        if (allTestsPassed) {
            System.out.println("----------------------------------------");
            System.out.println("All test case passed!");

        } else {
            System.out.println("----------------------------------------");
            System.out.println("Some test case failed!");

        }

    }

}
