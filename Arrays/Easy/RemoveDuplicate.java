package Easy;

import java.util.ArrayList;
/**
 * * Remove duplicate from sorted array.
 * 
 * Given a sorted array arr[] of size n, the goal is to rearrange the array so
 * that all distinct elements appear at the beginning in sorted order
 * Additionally, return the length of this distinct sorted subarray.
 * Note: The elements after the distinct ones can be in any order and hold any
 * value, as they don’t affect the result.
 * 
 * Examples: 
 * Input: arr[] = [2, 2, 2, 2, 2
 * Output: [2
 * Explanation: All the elements are 2, So only keep one instance of 2.
 * 
 * Input: arr[] = [1, 2, 2, 3, 4, 4, 4, 5, 
 * Output: [1, 2, 3, 4, 5
 * Input: arr[] = [1, 2, 
 * Output: [1, 2, 
 * Explanation : No change as all elements are distinct.
 * 
 * 
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {
    public static int[] removeDuplicate(int arr[]) {
        if (arr == null || arr.length == 0 || arr.length < 2) {
            return arr;
        }

        int temp[] = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < k; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[k++] = arr[i];
            }

        }

        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int removeDuplicateArr(int nums[]){
        if(nums == null || nums.length < 2){
            return 0;
        }

        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int[] usingHashSet(int arr[]) {
        if (arr == null || arr.length == 0 || arr.length < 2) {
            return arr;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int result[] = new int[set.size()];
        int k = 0;
        for (Integer i : set) {
            result[k++] = i;
        }

        return result;
    }

    public static int[] removingUsingList(int arr[]) {
        if (arr == null || arr.length == 0 || arr.length < 2) {
            return arr;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }

        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 2, 2, 2 };
        int arr1[] = { 1, 1, 2};
        int nums[] = {1, 1, 2};
        System.out.print("After removing the duplicate in an array: ");
        System.out.println(Arrays.toString(removeDuplicate(arr)));
        System.out.println("Using HashSet: " + Arrays.toString(usingHashSet(arr1)));

        System.out.println("Using list: " + Arrays.toString(removingUsingList(arr1)));

        int j = removeDuplicateArr(nums);
        for(int i = 0; i < j; i++){
            System.out.println(nums[i]);
        }
    }
}
