/**
 * *Finding the third largest element in an array.
 */

package Easy;

public class ThirdLargest {

    public static Integer thirdLargest(int arr[]) {
        if (arr == null || arr.length < 3) {
            return null;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            first = Math.max(first, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < first) {
                second = Math.max(second, arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < second) {
                third = Math.max(third, arr[i]);
            }
        }

        if (third == Integer.MIN_VALUE) {
            return null;
        }

        return third;
    }

    public static Integer thirdLarge(int arr[]) {
        if (arr == null || arr.length < 3) {
            return null;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third && arr[i] != second && arr[i] != first) {
                third = arr[i];
            }
        }

        if (third == Integer.MIN_VALUE) {
            return null;
        }

        return third;
    }

    public static void main(String[] args) {

        try {
            int[][] testArrays = {
                {}, // Edge case: empty array
                { 5 }, // Edge case: single element array
                { 5, 5 }, // Case: both elements are the same
                { 1, 2, 3, 4, 5 }, // Normal case: distinct elements
                { 10, 5, 2, 10, 5 }, // Case: some duplicate elements
                { 2, 2, 2, 2, 2 }, // Case: all elements are the same
                { 1, -4, 3, -6, 7, 0 }, // containing negative elements
                { 10, 3, 5, 6, 20 },
                { -10, -3, -5, -6, -20 }// containing negative elements
        };

            for (int[] arr : testArrays) {
                Integer result = thirdLarge(arr);
                System.out.println("Array: " + java.util.Arrays.toString(arr) + " => Third Largest: "
                        + (result == null ? "None" : result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
