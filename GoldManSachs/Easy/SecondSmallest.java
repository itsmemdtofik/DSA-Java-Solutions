package GoldManSachs.Easy;

/**
 * * ::Second Smallest::
 * 
 * Q2. Find the second smallest element in an array.
 * Important to take note of the word element
 * For example, [4,8, 9, 2, 1, 1] should return 1, not 2.
 * Also, if array.length is less than 2, just immediately return zero.
 */
public class SecondSmallest {

    // Method to find the second smallest element
    public static Integer findSecondSmallest(int[] arr) {
        // Edge case: If the array has fewer than two elements, return null
        if (arr == null || arr.length < 2) {
            return null;
        }

        // Initialize the smallest and second smallest with maximum possible values
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // Traverse the array to find the smallest and second smallest
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;  // Update second smallest before updating smallest
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        // If second smallest is still Integer.MAX_VALUE, no second smallest exists
        if (secondSmallest == Integer.MAX_VALUE) {
            return null;
        }

        return secondSmallest;
    }
    public static void main(String[] args) {
        
        int[][] testArrays = {
            {},               // Edge case: empty array
            {5},              // Edge case: single element array
            {5, 5},           // Case: both elements are the same
            {1, 2, 3, 4, 5},  // Normal case: distinct elements
            {10, 5, 2, 10, 5},// Case: some duplicate elements
            {2, 2, 2, 2, 2}   // Case: all elements are the same
        };

        for (int[] arr : testArrays) {
            Integer result = findSecondSmallest(arr);
            System.out.println("Array: " + java.util.Arrays.toString(arr) 
                               + " => Second smallest: " + (result == null ? "None" : result));
        }
    }

}
