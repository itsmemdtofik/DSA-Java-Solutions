package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ! Majority Element II - An element that occure [arr.length / 3] times.
 * 
 * Given an array arr[] consisting of n integers, the task is to find all the
 * array elements which occurs more than floor(n/3) times.
 * Note: The returned array of majority elements should be sorted.
 * 
 * Examples:
 * 
 * Input: arr[] = {2, 2, 3, 1, 3, 2, 1, 1}
 * Output: {1, 2}
 * Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3
 * = 2).
 * 
 * 
 * Input: arr[] = {-5, 3, -5}
 * Output: {-5}
 * Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 =
 * 1).
 * 
 * 
 * Input: arr[] = {3, 2, 2, 4, 1, 4}
 * Output: { }
 * Explanation: There is no majority element.
 * 
 * 
 */
public class MajorityElementII {

    public static List<Integer> majorityIIElement(int nums[]) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        /**
         * * Boyer-Moore Voting Algorithm
         * How the Boyer-Moore Voting Algorithm Works
         * The Boyer-Moore Voting Algorithm operates in two phases:
         * 
         * Phase 1: Candidate Selection
         * Phase 2: Candidate Verification
         * 
         * Step1: Find potential candidate or candidate selection.
         * Iterate through the loop.
         */
        int firstCandidate = 0;
        int secondCandidate = 0;

        int firstCount = 0;
        int secondCount = 0;
        for (int num : nums) {
            if (firstCandidate != 0 && num == firstCandidate) {
                firstCount++;
            } else if (firstCandidate != 0 && num == secondCandidate) {
                secondCount++;
            } else if (firstCount == 0) {
                firstCandidate = num;
                firstCount = 1;
            } else if (secondCount == 0) {
                secondCandidate = num;
                secondCount = 1;
            } else {
                firstCount--;
                secondCount--;
            }
        }

        /**
         * Step2: Verify the candidate
         * Reset count to 0
         */
        firstCount = 0;
        secondCount = 0;
        for (int num : nums) {
            if (num == firstCandidate) {
                firstCount++;
            } else if (num == secondCandidate) {
                secondCount++;
            }
        }

        /**
         * Step3: Check if the counts are more than [arr.length / 3]
         * Add the valid the candidate to the list result.
         */
        if (firstCount > nums.length / 3) {
            result.add(firstCandidate);
        }
        if (secondCount > nums.length / 3) {
            result.add(secondCandidate);
        }

        /**
         * Step4: Sort the result before returning
         */
        Collections.sort(result);
        return result;

    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 1, 1, 2, 3, 4, 4, 4 };
        System.out.println(majorityIIElement(arr1)); // Output: [1, 2]

        int[] arr2 = { -5, 3, -5 };
        System.out.println(majorityIIElement(arr2)); // Output: [-5]

        int[] arr3 = { 3, 2, 2, 4, 1, 4 };
        System.out.println(majorityIIElement(arr3)); // Output: []
    }
}
