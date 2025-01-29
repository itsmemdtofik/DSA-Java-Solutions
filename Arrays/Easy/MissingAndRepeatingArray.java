package Easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * ! Missing and repeating in an array.
 * 
 * Given an unsorted array of size n. Array elements are in the range of 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the
 * array. Find these two numbers.
 * 
 * Examples:
 * 
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 * Explanation: In the array, 2 is missing and 3 occurs twice
 * 
 * 
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * Output: Missing = 5, Repeating = 1
 */
public class MissingAndRepeatingArray {

    /**
     * Approach: 1
     * Step1: Create a temp array visited[] of size n+1 with all initial values as
     * false.
     * Note that array values go upto n, that is why we have taken size as n+1.
     * 
     * Step2: Traverse the input array arr[], and do the following for each arr[i]
     * if(visited[arr[i]] == false), set visited[arr[i]) = true;
     * if(visited[arr[i]] == true) output “arr[i]” //repeating number
     * 
     * Step3: Traverse visited[] and output ‘i’ corresponding to the
     * element of array visited[] having value as false. (This is the missing
     * number)
     * 
     * @param args
     */

    public static void missingAndRepeating(int nums[]) {

        boolean visited[] = new boolean[nums.length + 1];
        int repeating = -1;
        int missing = -1;

        Arrays.fill(visited, false);

        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i]]) {
                repeating = nums[i];
            } else {
                visited[nums[i]] = true;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!visited[i]) {
                missing = i;
                break;
            }
        }

        System.out.println("Repeating : " + repeating);
        System.out.println("Missing : " + missing);
    }

    /**
     * * Approach : 2
     * 
     * Step1: Initialize a set to keep track of numbers we encounter while iterating
     * over
     * the array.
     * Step2: Iterate through the array:
     * If the number is already in the set, it means this is the repeating number.
     * If the number is not in the set, add it to the set.
     * Step3: The missing number is the one that doesn't appear in the set (from the
     * range 1 to n).
     * 
     * 
     * @param args
     */

    public static int[] findMissingAndRepeating(int nums[]) {

        if (nums == null || nums.length < 2) {
            return nums;
        }

        HashSet<Integer> set = new HashSet<>();
        int repeating = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                repeating = num;
            } else {
                set.add(num);
            }
        }

        int missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[] { missing, repeating };
    }

    /**
     * * Approach: Making Two Math Equation.
     * 
     * Let x be the missing and y be the repeating element.
     * Let N is the size of the array.
     * Get the sum of all numbers using the formula sum = N(N+1)/2
     * Get the sum of square of all numbers using formula sumSQ = N(N+1)(2N+1)/6
     * Iterate through a loop from i = 1….N and do the following :
     * sum -= A[i], sumSQ -=(A[i]*A[i])
     * 
     * @param args
     */
    public static void AnotherMethodMissingRepeating(int nums[]) {

        int n = nums.length;

        long sum = (long) (n * (n + 1)) / 2;
        long sumSQ = (long) ((n * (n + 1)) * (2 * n + 1)) / 6;

        long missing = 0;
        long repeating = 0;

        for (int i = 0; i < n; i++) {
            sum = sum - nums[i];
            sumSQ = (long) sumSQ - nums[i] * nums[i];
        }
        missing = (sum + sumSQ / sum) / 2;
        repeating = missing - sum;

        System.out.println("Repeating: " + repeating);
        System.out.println("Missing : " + missing);

    }

    public static void main(String[] args) {

        int[] arr = { 7, 3, 4, 5, 5, 6, 2 };
        missingAndRepeating(arr);

        int[] arr1 = { 3, 1, 3 };
        int[] arr2 = { 4, 3, 6, 2, 1, 1 };

        int[] result1 = findMissingAndRepeating(arr1);
        System.out.println("Missing = " + result1[0] + ", Repeating = " + result1[1]);

        int[] result2 = findMissingAndRepeating(arr2);
        System.out.println("Missing = " + result2[0] + ", Repeating = " + result2[1]);

        AnotherMethodMissingRepeating(arr1);
        AnotherMethodMissingRepeating(arr2);

    }
}
