/**
 * * Reaarange element by sign.
 * 
 * Given an array arr[] of size n, the task is to rearrange it in alternate
 * positive and negative manner without changing the relative order of positive
 * and negative numbers. In case of extra positive/negative numbers, they appear
 * at the end of the array.
 * 
 * Note: The rearranged array should start with a positive number and 0 (zero)
 * should be considered as a positive number.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 2, 3, -4, -1, 4}
 * Output: arr[] = {1, -4, 2, -1, 3, 4}
 * 
 * 
 * Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 * 
 * Approach: 
 * Step1: Create two list one for non-negative and one for negative.
 * Step2: Seperate(Divide) and Merge the positiive and Negative list alternatively.
 * Step3: Handle remaining Positive and Negative Number.
 * Step4: Convert list back into an array.
 * 
 */

package Easy;

import java.util.ArrayList;
import java.util.List;

public class AlternatePositiveNegative {

    public static int[] rearrangeElementBySign(int nums[]) {
        if (nums == null || nums.length == 0 || nums.length < 2) {
            return nums;
        }

        List<Integer> positiiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) {
                positiiveList.add(num);
            } else {
                negativeList.add(num);
            }
        }

        List<Integer> mergeList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < positiiveList.size() && j < negativeList.size()) {
            mergeList.add(positiiveList.get(i++));
            mergeList.add(negativeList.get(j++));
        }

        while (i < positiiveList.size()) {
            mergeList.add(positiiveList.get(i++));
        }

        while (j < negativeList.size()) {
            mergeList.add(negativeList.get(j++));
        }

        int[] result = new int[mergeList.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = mergeList.get(k);
        }

        return result;
    }

    public static void main(String[] args) {

        // Example 1
        int[] arr1 = { 1, 2, 3, -4, -1, 4 };
        int[] result1 = rearrangeElementBySign(arr1);
        System.out.print("Rearranged Array 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2
        int[] arr2 = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int[] result2 = rearrangeElementBySign(arr2);
        System.out.print("Rearranged Array 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

    }
}
