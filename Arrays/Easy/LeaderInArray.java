/**
 * * Leaders in an Array;
 * 
 * Given an array arr[] of size n, the task is to find all the Leaders in the array. An element is a Leader if it is greater than or equal to all the elements to its right side.
 * Note: The rightmost element is always a leader.
 * 
 * Examples
 * 
 * Input: arr[] = [16, 17, 4, 3, 5, 2]
 * Output: [17 5 2] 
 * Explanation: 17 is greater than all the elements to its right i.e., [4, 3, 5, 2
 * therefore 17 is a leader. 5 is greater than all the elements to its right i.e
 * [2], therefore 5 is a leader. 2 has no element to its right, therefore 2 is
 * leader.
 * 
 * Input: arr[] = [1, 2, 3, 4, 5, 2]
 * Output: [5,2]
 * Explanation: 5 is greater than all the elements to its right i.e., [2], therefo
 * 5 is a leader. 2 has no element to its right, therefore 2 is a leader.
 * 
 * ? Approach:
 * 
 * Step1: Start from the end(rightmost element), which is always a leader.
 * Step2: Traverse the array from right to left, compare each element with the leader.
 * Step3: If an element id greater thant or equal to leader, it is leader and we update the leader.
 * Step4: Stores the leader in list(Since we are processing from right to left, we will reverse result list at the end).
 * The final list of leaders will be in reverse order, so reverse it before returning.
 * 
 */

package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {

    public static List<Integer> leaderInArr(int nums[]){

        

        int leader = nums[nums.length - 1];
        List<Integer> list = new ArrayList<>();
        list.add(leader);
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= leader){
                list.add(nums[i]);
                leader = nums[i];
            }
        }

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, 3, 4, 5, 2};
        System.out.println("Leaders in array 1: " + leaderInArr(arr1));

        int[] arr2 ={16, 17, 4, 3, 5, 2};
        System.out.println("Leaders in arr2: " + leaderInArr(arr2));
    }
}
