/**
 * *Reverse an Array in groups of given size.
 * 
 * Given an array arr[] and an integer K, the task is to reverse every 
 * subarray formed by consecutive K elements.

Examples: 

Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9], K = 3 
Output: 3, 2, 1, 6, 5, 4, 9, 8, 7


Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], K = 5 
Output: 5, 4, 3, 2, 1, 8, 7, 6


Input: arr[] = [1, 2, 3, 4, 5, 6], K = 1 
Output: 1, 2, 3, 4, 5, 6


Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], K = 10 
Output: 8, 7, 6, 5, 4, 3, 2, 1.

 */

package Easy;

import java.util.Stack;

public class ReverseArrayInGroup {

    public static int[] reverseArrayInGroup(int arr[], int K) {

        if (arr.length == 0 || arr.length < 3) {
            return arr;
        }

        for (int i = 0; i < arr.length; i += K) {

            int left = i;
            int right = Math.min(i + K - 1, arr.length - 1);

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return arr;

    }

    public static int[] reverseArrIngroup(int arr[], int K){
        if (arr.length == 0 || arr.length < 3) {
            return arr;
        }

        for(int start = 0; start < arr.length; start += K){
            Stack<Integer> stack = new Stack<>();

            for(int end = start; end < start + K && end < arr.length; end++){
                stack.push(arr[end]);
            }

            int idx = start;
            while(!stack.isEmpty()){
                arr[idx++] = stack.pop();
            }

        }
        return arr;
    }

    public static void main(String[] args) {

        int K = 3;
        int arr[] = { 1,2,2, 3, 4, 5, 6, 7, 8 };

        int result[] = reverseArrIngroup(arr, K);

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
