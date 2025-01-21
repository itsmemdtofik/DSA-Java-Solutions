/**
 * 
 * * Insert duplicate of K adjacent to it for its every occurances in array.
 * 
 * Given an array arr consisting of N integers and an integer K, the task is to
 * insert an adjacent K for every occurrence of it in the original sequence and
 * then truncate the array to the original length using an O(1) auxiliary space.
 * 
 * Examples:
 * 
 * 
 * Input: arr[] = {1, 0, 2, 3, 0, 4, 5, 0}, K = 0
 * Output: {1, 0, 0, 2, 3, 0, 0, 4}
 * Explanation:
 * The given array {1, 0, 2, 3, 0, 4, 5, 0} is modified to {1, 0, 0, 2, 3, 0, 0,
 * 4] after insertion of two 0’s and truncation of extra elements.
 * 
 * 
 * Input: arr[] = {7, 5, 8}, K = 8
 * Output: {7, 5, 8}
 * Explanation:
 * After inserting an adjacent 8 into the array, it got truncated to restore the
 * original size of the array.
 * 
 */

package Easy;
public class InsertDuplicateElement {

    public static int[] insertDuplicate(int nums[], int K){

        if(nums == null || nums.length == 0 || nums.length < 2){
            return nums;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == K){
                count++;
            }
        }

        int n = nums.length + count;
        int newarr[] = new int[n];
        int j = 0;

        for(int i = 0; i < nums.length; i ++){
            newarr[j++] = nums[i];
            if(nums[i] == K){
                newarr[j++] = K;
            }
        }

        return newarr;
        
    }
    public static void main(String[] args) {

        int arr1[] = {7, 5, 8};
        int K1 = 8;

        int arr2[] = {1, 0, 2, 3, 0, 4, 5, 0};
        int K2 = 0;

        
        int m[] = insertDuplicate(arr1, K1);
        System.out.print("Elements are: ");
        for(int i = 0; i < arr1.length; i++){
            System.out.print(m[i] + ", ");
        }
        System.out.println();

        int n[] = insertDuplicate(arr2, K2);
        System.out.print("Elements are: ");
        for(int i = 0; i < arr2.length; i++){
            System.out.print(n[i] + ", ");
        }
        System.out.println();
    }
}
