package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ! Majority Element in an Array.
 * 
 * Given an array arr. Find the majority element in the array. If no majority
 * exists, return -1. A majority element in an array is an element that appears
 * strictly more than arr.size() / 2 times in the array.
 * 
 * Examples :
 * 
 * Input : arr[] = {1, 1, 2, 1, 3, 5, 1}
 * Output : 1
 * Explanation: Note that 1 appear 4 times which is more than 7 / 2 times
 * 
 * 
 * Input : arr[] = {3, 3, 4, 2, 4, 4, 2, 4}
 * Output : -1
 * Explanation: There is no element whose frequency is greater than the half of
 * the size of the array size.
 * 
 * 
 * Input : arr[] = {3}
 * Output : 3
 * Explanation: Appears more than n/2 times
 */
public class MejorityElement {

    public static int findMajority(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                return arr[i];
            }
        }

        return -1;
    }

    public static int anotherMajority(int arr[]) {

        if(arr.length == 0){
            return -1;
        }
        /**
         * Step1: Find the candidate
         */
        int candidate = 0;
        int count = 0;
        for (int num : arr) {
            if(num == candidate){
                count++;
            }
            else if (count == 0) {
                candidate = num;
                count = 1;
            }else{
                count--;
            }
            
        }

        /**
         * Step2: varify the candidate
         */
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        /**
         * Step3: If the candidate appears more than arr.length / 2, return it.
         */
        if(count > arr.length / 2){
            return candidate;
        }

        return -1;
    }

    public static int usingHashing(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            /**
             * Traverse the array and count the occurances using the hash map.
             */
            map.put(num, map.getOrDefault(num, 0) + 1);

            /**
             * Check if current element count exceeds arr.length / 2
             */
            if (map.get(num) > arr.length / 2) {
                return num;
            }
        }

        /**
         * If no majority element is found, return -1
         */
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(usingHashing(arr1)); // Output: 1

        int[] arr2 = { 3, 3, 4, 2, 4, 4, 2, 4 };
        System.out.println(usingHashing(arr2)); // Output: -1

        int[] arr3 = { 3 };
        System.out.println(usingHashing(arr3)); // Output: 3
    }
}
