/**
 * * Move all zeros to end of an array.
 * Given an array of integers arr[], the task is to move all the zeros to 
 * the end of the array while maintaining the relative order of all non-zero elements.

Examples: 

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.


Input: arr[] = [10, 20, 30]
Output: arr[] = [10, 20, 30]
Explanation: No change in array as there are no 0s.

Input: arr[] = [0, 0]
Output: arr[] = [0, 0]
Explanation: No change in array as there are all 0s.
 * 
 */
package Easy;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public static int[] movezerotoend(int arr[]) {

        if (arr.length < 0 || arr.length == 1) {
            return arr;
        }

        int zero[] = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                zero[j++] = arr[i];
            }
        }

        while (j < arr.length) {
            zero[j++] = 0;
        }

        return zero;
    }

    public static int[] pushZerosToEnd(int arr[]){
        if(arr.length < 0 || arr.length == 0){
            return arr;
        }

        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[j++] = arr[i];
            }
        }

        while(j < arr.length){
            arr[j++] = 0;
        }

        return arr;
    }

    public static int[] pushtoend(int arr[]){
        if(arr.length == 0 || arr.length < 2){
            return arr;
        }

        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }

        return arr;
    }


    public static void main(String[] args) {

        try {
            int[][] testArrays = {
                    {0}, // Edge case: empty array
                    { 5 }, // Edge case: single element array
                    { 5, 5 }, // Case: both elements are the same
                    { 1, 2, 3, 4, 5 }, // Normal case: distinct elements
                    { 10, 5, 2, 10, 5 }, // Case: some duplicate elements
                    { 2, 2, 2, 2, 2 }, // Case: all elements are the same
                    { 1, -4, 3, -6, 7, 0 }, // containing negative elements
                    { 10, 3, 5, 6, 20 },
                    { -10, -3, -5, -6, -20 }, // containing negative elements
                    { 1, 2, 0, 4, 3, 0, 5, 0 },
            };

            for (int[] arr : testArrays) {
                int result[] = pushtoend(arr);

                boolean bool = false;
                if (bool) {
                    System.out.println("Arrays contains non - zero : " + Arrays.toString(result));
                } else {
                    System.out.println("Moved to end : " + (result == null ? "None" : Arrays.toString(result)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}