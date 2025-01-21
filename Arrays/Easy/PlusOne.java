/**
 * * Adding one the number represented as a carry of digits.
 * 
 * Approach:
 * 
 * Step1: Start from least significant bit digit(i.g., The last element of an
 * array) and add 1.
 * Step2: If adding 1 to the last element become 10 then set that position to 0
 * and propagate carry. Move this carry 1 to the left element.
 * Step3: If there is no carry, the process stop.
 * Step4: If you reach the most significant digit(the first element) and still
 * have carry, you prepend 1 to array.
 * 
 * Example:
 * Input = [1, 2, 4]
 * Output = {1, 2, 5}
 * 
 * Input = [9, 9, 9]
 * Output = [1, 0, 0, 0]
 * 
 */

package Easy;

import java.util.Arrays;

public class PlusOne {
    public static int[] addOne(int arr[]) {
        if (arr.length == 0) {
            return arr;
        }

        // Start from the last digit and add carry which is initially one.
        int carry = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] + carry;

            if (arr[i] == 10) {
                arr[i] = 0;
                carry = 1; // Carry to the next digit.
            } else {
                carry = 0;// No carry left, exit the loop.
                break;
            }
        }

        // If there's still a carry left, we need to add it as a new most significant
        // digit.
        if (carry == 1) {
            int result[] = new int[arr.length + 1];

            // Copy the element from the arr to new array result from index 1.
            for (int i = 0; i < arr.length; i++) {
                result[i + 1] = arr[i];
            }
            result[0] = 1;
            return result;
        }

        return arr;
    }

    public static void main(String[] args) {

        int arr[] = { 9 };
        int arr1[] = { 1, 2, 4 };
        int arr2[] = { 9, 9, 9 };
        int arr3[] = { 1, 7, 8, 9 };
        int arr4[] = { 9, 8, 9, 9 };
        int arr5[] = {};

        System.out.print("After adding one : ");
        System.out.println(Arrays.toString(addOne(arr)));
        System.out.println(Arrays.toString(addOne(arr1)));
        System.out.println(Arrays.toString(addOne(arr2)));
        System.out.println(Arrays.toString(addOne(arr3)));
        System.out.println(Arrays.toString(addOne(arr4)));
        System.out.println(Arrays.toString(addOne(arr5)));
        System.out.println();
    }
}
