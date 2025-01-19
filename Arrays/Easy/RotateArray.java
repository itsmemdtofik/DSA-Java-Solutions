package Easy;

/**
 * * Rotate array by D position - Counter clockwise or left.
 * Given an array of integers arr[] of size n, the task is to rotate the array
 * elements to the left by d positions.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
 * Output: {3, 4, 5, 6, 1, 2}
 * Explanation: After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1} and
 * after the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2}
 * 
 * 
 * Input: arr[] = {1, 2, 3}, d = 4
 * Output: {2, 3, 1}
 * Explanation: The array is rotated as follows:
 * 
 * 
 * After first left rotation, arr[] = {2, 3, 1}
 * After second left rotation, arr[] = {3, 1, 2}
 * After third left rotation, arr[] = {1, 2, 3}
 * After fourth left rotation, arr[] = {2, 3, 1}
 * 
 */
public class RotateArray {

    /**
     * Simple solution first storing the first elment of an array in first variable.
     * And then going through 0 to arr.length - 1 and storing from j + 1 element to an array.
     * This step repeat one by one. This is very basic solution.
     * @param arr
     * @param d
     * @return
     */
    public static int[] rotateArrayInCounterclockwise(int arr[], int d){

        //Handle the case where d >= arr.length reducing to d % arr.length.
        d = d % arr.length;

        int first = arr[0];
        for(int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[ i + 1];
        }

        arr[arr.length - 1] = first;

        int second = arr[0];
        for(int j = 0; j < arr.length - 1; j++){
            arr[j] = arr[j+1];
        }

        arr[arr.length - 1] = second;

        return arr;
    }

    /**
     * Method-2: USing helper function.
     * Step1: Rotate the entire array from 0 to arr.length - 1
     * Step2: rotate the first part from 0 to d - 1.
     * Step3: rotate the second part from d to arr.length - 1.
     * @param arr
     * @param D
     * @return
     */

    public static int[] rotateArrayByDPosition(int arr[], int D){

        if(arr.length < 1){
            return arr;
        }

        //Handle the case where d become >= arr.length.
        D = D % arr.length;

        //Step1
        reverse(arr, 0, arr.length - 1);

        //Step2
        reverse(arr, 0, D - 1);

        //Step3
        reverse(arr, D, arr.length - 1);

        return arr;

    }

    
    public static void reverse(int arr[], int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};
        int d = 2;

        int rotate[] = rotateArrayByDPosition(arr, d);
        for(int i: rotate){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
