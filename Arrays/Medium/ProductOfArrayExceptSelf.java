package Medium;

import java.util.Arrays;

/**
 * * Product of an Array Except Self.
 * 
 * Given an array arr[] of n integers, construct a product array res[] (of the
 * same size) such that res[i] is equal to the product of all the elements of
 * arr[] except arr[i].
 * 
 * Example:
 * 
 * Input: arr[] = [10, 3, 5, 6, 2]
 * Output: [180, 600, 360, 300, 900]
 * 
 * Explanation:
 * For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
 * For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
 * For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
 * For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
 * For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
 * 
 * Input: arr[] = [12, 0]
 * Output: [0, 12]
 * Explanation:
 * 
 * 
 * For i = 0, res[i] = 0.
 * For i = 1, res[i] = 12.
 * 
 * Approach:
 * Step1: Create a temproray array and fill it by 1. We can do it by
 * Arrays.fill(result, 1). [1, 1, 1, 1]. We wil update this one by one.
 * Step2: Use two loop from 0 to n and compute the product.
 * 
 * Arr[] = {1, 2, 3, 4}
 * 
 * result[0] = 24
 * result[1] = 12
 * result[2] = 8
 * result[3] = 6
 */
public class ProductOfArrayExceptSelf {

    public static int[] productOfArrayExceptSelf(int arr[]) {

        if (arr == null) {
            return null;
        }

        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    result[i] *= arr[j];
                }
            }
        }
        return result;
    }

    public static int[] productOfArrayUsingLeftAndRight(int arr[]){
        if(arr == null){
            return null;
        }

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int result[] = new int[arr.length];

        //Step1: Calculate the left array. left[0] = 1, left[1] = 1, left[2] = 2, left[3] = 6
        left[0] = 1;
        for(int i = 1; i < arr.length; i++){
            left[i] = left[i - 1] * arr[i - 1];
        }

        //Step2: Calculate the right array. right[3] = 1 right[2] = 4, right[1] = 12, right[0] = 24.
        right[arr.length - 1] = 1;
        for(int j = arr.length - 2; j >= 0; j--){
            right[j] = right[j + 1] * arr[j + 1];
        }

        //Step3: Now multiply with left arr with right array.
        for(int i = 0; i < arr.length; i++){
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = {10, 3, 5, 6, 2};
        System.out.print("Product of an array except self element: ");
        System.out.println(Arrays.toString(productOfArrayExceptSelf(arr)));
        System.out.println(Arrays.toString(productOfArrayUsingLeftAndRight(arr1)));
    }
}
