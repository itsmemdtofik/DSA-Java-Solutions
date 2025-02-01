package Medium;

import java.util.Arrays;

/**
 * ! Next Permutation
 * 
 * Example: Permutations of [1, 2, 4]
 * To understand the problem, let's first list all the permutations of [1, 2, 4]
 * in lexicographical order:
 * 
 * [1, 2, 4]
 * [1, 4, 2]
 * [2, 1, 4]
 * [2, 4, 1]
 * [4, 1, 2]
 * [4, 2, 1]
 * 
 * * General Approach to Solve the Problem:
 * 
 * To solve this problem programmatically, you can use the following algorithm
 * that follows the idea of finding the next permutation in lexicographical
 * order:
 * 
 * Step1: Find the rightmost pair of consecutive elements (arr[i], arr[i+1]) where
 * arr[i] < arr[i+1].
 * This step finds the point where the order breaks from increasing to decreasing.
 * Step2: Find the smallest element that is larger than arr[i], and swap them.
 * Step3: Reverse the sequence after the swapped element to get the smallest
 * lexicographical order.
 * 
 */

public class NextPermutation {

    public static void nextPermutation(int arr[]){

        //Step1: Find the largest index j such that arr[i] < arr[i + 1]
        int j = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                j = i;
                break;
            }
        }

        //If no such k exists, the array is in descending order, reverse it.
        if(j == - 1){
            reverse(arr, 0, arr.length - 1);
            return;
        }

        //Step2: Find the largest index k such that arr[j] < arr[i]
        int k = - 1;
        for(int i = arr.length - 1; i > j; i--){
            if(arr[j] < arr[i]){
                k = i;
                break;
            }
        }

        //Step3: Swap arr[k] and arr[largeIndex]
        swap(arr, j, k);

        //Step4: Reverse the sequence from k + 1 to end
        reverse(arr, j + 1, arr.length - 1);
    }

    private static void reverse(int arr[], int begin, int end){
        while(begin < end){
            swap(arr, begin, end);
            begin++;
            end--;
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

        int[] arr1 = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr1);
        System.out.println("Next permutation of [2, 4, 1, 7, 5, 0]: " + Arrays.toString(arr1));

        int[] arr2 = {3, 2, 1};
        nextPermutation(arr2);
        System.out.println("Next permutation of [3, 2, 1]: " + Arrays.toString(arr2));
    }
}
