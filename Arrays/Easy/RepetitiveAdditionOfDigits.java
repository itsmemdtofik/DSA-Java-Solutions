package Easy;

/**
 * * Fiding the some of digits of a number until sum become single digit.
 * 
 * Given an integer n, we need to repeatedly find the sum of its digits until
 * the result becomes a single-digit number.
 * 
 * Examples:
 * 
 * Input: n = 1234
 * Output: 1
 * Explanation:
 * Step 1: 1 + 2 + 3 + 4 = 10
 * Step 2: 1 + 0 = 1
 * 
 * 
 * Input: n = 5674
 * Output: 4
 * Explanation:
 * Step 1: 5 + 6 + 7 + 4 = 22
 * Step 2: 2 + 2 = 4
 * 
 */

 public class RepetitiveAdditionOfDigits {

    public static int findSumOfDigit(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }

        long sumArr = 0;
        int sumOfDigit = 0;
        for(int i = 0; i < arr.length; i++){
            sumArr = sumArr + arr[i];
        }

        while(sumArr != 0){
            int rem = (int)sumArr % 10;
            sumOfDigit = sumOfDigit + rem;
            sumArr = sumArr / 10;
        }

        return sumOfDigit;
    }
 
    public static void main(String[] args) {
        
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {5, 6, 7, 4};
        int arr3[] = {9, 6, 8, 4};
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] arr6 = {10, -5, 20}; // sum = 10 + (-5) + 20 = 25
        System.out.print("The sum of digit is: ");
        System.out.println(findSumOfDigit(arr1));
        System.out.println(findSumOfDigit(arr2));
        System.out.println(findSumOfDigit(arr3));
        System.out.println(findSumOfDigit(arr4));
        System.out.println(findSumOfDigit(arr5));
        System.out.println(findSumOfDigit(arr6));
    }
 }