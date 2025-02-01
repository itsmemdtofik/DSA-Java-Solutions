package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ! Missing ranges of numbers.
 * 
 * You have an inclusive interval [lower, upper] and a sorted array of unique
 * integers arr[], all of which lie within this interval. A number x is
 * considered missing if x is in the range [lower, upper] but not present in
 * arr. Your task is to return the smallest set of sorted ranges that includes
 * all missing numbers, ensuring no element from arr is within any range, and
 * every missing number is covered exactly once.
 * 
 * Examples
 * 
 * Input: arr[] = [14, 15, 20, 30, 31, 45], lower = 10, upper = 50
 * Output: [[10, 13], [16, 19], [21, 29], [32, 44], [46, 50]]
 * Explanation: These ranges represent all missing numbers between 10 and 50 not
 * present in the array
 * 
 * Input: arr[] = [-48, -10, -6, -4, 0, 4, 17], lower = -54, upper = 17
 * Output: [[-54, -49], [-47, -11], [-9, -7], [-5, -5], [-3, -1], [1, 3],
 * [5,16]]
 * Explanation: These ranges represent all missing numbers between -54 and 17
 * not present in the array.
 * 
 * 
 * 
 */
public class MissingRangesOfNumber {

    /**
     * * Kea Idea:
     * 
     * Check the range before the first element of arr[].
     * Check the gaps between consecutive elements in arr[].
     * Check the range after the last element of arr[].
     * 
     * @param args
     */

    public static List<int[]> findMissingRanges(int arr[], int lower, int upper) {

        List<int[]> result = new ArrayList<>();

        // Handle the range before the first element in the array.
        if (arr.length == 0 || arr[0] > lower) {
            result.add(new int[] { lower, arr[0] - 1 });
        }

        // Handle the gap between consecutive elements in the array.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                result.add(new int[] { arr[i - 1] + 1, arr[i] - 1 });
            }
        }

        // Handle the range after the last element in the array.
        if (arr.length == 0 || arr[arr.length - 1] < upper) {
            result.add(new int[] { arr[arr.length - 1] + 1, upper });
        }

        return result;
    }

    /**
     * * Another method to solve this problem.
     * 
     * Step1: Track the current number starting at lower.
     * Step2: For each number in the array, check if the current number is less than it.
     * If yes, we have a gap. Add the missing ranges from current to arr[i] - 1.
     * Then, update current to arr[i] + 1 (since we have handled that number).
     * Step3: Finally, check after the last number in arr[], if there is any gap left to upper.
     * @param result
     */

     public static List<int[]> anotherFindMissingRanges(int arr[], int lower, int upper){
        List<int[]> result = new ArrayList<>();

        int current = lower;

        //Traverse the array and check for missing ranges.
        for(int num: arr){
            if(num > current){
                //If there is a gap between current and num
                result.add(new int[]{current, num - 1});
            }
            //Update current to the next number after the current num
            current = num + 1;
        }

        //Handle the remaining range after the last element in the array.
        if(current <= upper){
            result.add(new int[]{current, upper});
        }

        return result;
     }

    // Helper function to print the result.
    public static void printMissingRanges(List<int[]> result) {
        for (int[] range : result) {
            if (range[0] == range[1]) {
                System.out.println(range[0]);
            } else {
                System.out.println("[" + range[0] + ", " + range[1] + "]");
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 = { 14, 15, 20, 30, 31, 45 };
        int lower1 = 10, upper1 = 50;
        List<int[]> missingRanges1 = findMissingRanges(arr1, lower1, upper1);
        printMissingRanges(missingRanges1);

        System.out.println(); // For separating outputs

        int[] arr2 = { -48, -10, -6, -4, 0, 4, 17 };
        int lower2 = -54, upper2 = 17;
        List<int[]> missingRanges2 = findMissingRanges(arr2, lower2, upper2);
        printMissingRanges(missingRanges2);

    }
}
