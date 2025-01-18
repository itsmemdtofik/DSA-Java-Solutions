/**
 * *Finding the second largest elements in an array.
 * 
 */

package Easy;


public class SecondLargest {

    public static Integer secondLargest(int arr[]) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            first = Math.max(first, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < first) {
                second = Math.max(second, arr[i]);
            }
        }

        if (second == Integer.MIN_VALUE) {
            return null;
        }
        return second;
    }

    public static Integer secondLarge(int arr[]){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }

        if(second == Integer.MIN_VALUE){
            return null;
        }

        return second;
    }

    public static void main(String[] args) {
        try {
            int[][] testArrays = {
                    {}, // Edge case: empty array
                    { 5 }, // Edge case: single element array
                    { 5, 5 }, // Case: both elements are the same
                    { 1, 2, 3, 4, 5 }, // Normal case: distinct elements
                    { 10, 5, 2, 10, 5 }, // Case: some duplicate elements
                    { 2, 2, 2, 2, 2 } // Case: all elements are the same
            };

            for (int[] arr : testArrays) {
                Integer result = secondLarge(arr);
                System.out.println("Array: " + java.util.Arrays.toString(arr)
                        + " => Second Largest: " + (result == null ? "None" : result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
