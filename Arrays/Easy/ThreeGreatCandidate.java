/**
 * * Maximum product of a triplet (subsequence of size 3) in array.
 * Approach is:
 * Step1: Find first and second and third largest element.
 * Step2: Return of first * second * third.
 * 
 * Given an integer array, find a maximum product of a triplet in the array.

Examples: 

Input:  [10, 3, 5, 6, 20]
Output: 1200
Explanation: Multiplication of 10, 6 and 20

Input:  [-10, -3, -5, -6, -20]
Output: -90

Input:  [1, -4, 3, -6, 7, 0]
Output: 168
 */

package Easy;

import java.util.*;

public class ThreeGreatCandidate {

    public static int productOfTriplet(int arr[]) {

        if (arr.length == 0 || arr.length < 3) {
            return 0;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third && arr[i] != first && arr[i] != second) {
                third = arr[i];
            }
        }

        if (third == Integer.MIN_VALUE && second == Integer.MIN_VALUE && first == Integer.MIN_VALUE) {
            return 0;
        }

        return (first * second * third);
    }

    public static void main(String[] args) {

        try {
            int[][] testArrays = {
                    {}, // Edge case: empty array
                    { 5 }, // Edge case: single element array
                    { 5, 5 }, // Case: both elements are the same
                    { 1, 2, 3, 4, 5 }, // Normal case: distinct elements
                    { 10, 5, 2, 10, 5 }, // Case: some duplicate elements
                    { 2, 2, 2, 2, 2 }, // Case: all elements are the same
                    { 1, -4, 3, -6, 7, 0 }, // containing negative elements
                    { 10, 3, 5, 6, 20 },
                    { -10, -3, -5, -6, -20 }// containing negative elements
            };

            for (int[] arr : testArrays) {
                int result = productOfTriplet(arr);
                System.out.println(
                        "Array: " + Arrays.toString(arr) + " => Second Largest: " + (result == 0 ? "None" : result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
