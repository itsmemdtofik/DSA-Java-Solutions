package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargeIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create a dp array where dp[i] represents the length of the LIS ending at i
        int n = nums.length;
        int[] dp = new int[n];
        // Initialize dp array, where each element is at least 1 (the number itself)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill the dp array bottom-up
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The length of the LIS is the maximum value in dp array
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static int lengthOfLISUsingBinarySearch(int arr[]) {

        @SuppressWarnings({ "unchecked", "rawtypes" })
        List<Integer> list = new ArrayList();

        for (int nums : arr) {
            int position = Collections.binarySearch(list, nums);
            if (position < 0) {
                position = -(position + 1);
            }
            if (position == list.size()) {
                list.add(nums);
            } else {
                list.set(position, nums);
            }

        }
        System.out.println(list);
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println("Length of LIS: " + lengthOfLIS(nums)); // Output: 6
        lengthOfLISUsingBinarySearch(nums);
      
    }
}
