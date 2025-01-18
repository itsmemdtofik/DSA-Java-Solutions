package Easy;

public class FourthAlrgestInArray {
    public static Integer fourthLargest(int arr[]){

        if(arr.length < 4 || arr.length == 0){
            return null;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int fourth = Integer.MIN_VALUE;


        for(int i = 0; i < arr.length; i++){
            if(arr[i] > first){
                fourth = third;
                third = second;
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] != first){
                fourth = third;
                third = second;
                second = arr[i];
            }else if(arr[i] > third && arr[i] != first && arr[i] != second){
                fourth = third;
                third = arr[i];
            }else if(arr[i] > fourth  && arr[i] != first && arr[i] != second && arr[i] != third){
                fourth = arr[i];
            }
        }

        if(fourth == Integer.MIN_VALUE){
            return null;
        }

        return fourth;
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
                Integer result = fourthLargest(arr);
                System.out.println("Array: " + java.util.Arrays.toString(arr)
                        + " => Fourth Largest: " + (result == null ? "None" : result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
