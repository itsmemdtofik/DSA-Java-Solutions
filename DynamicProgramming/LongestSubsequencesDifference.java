package DynamicProgramming;

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

public class LongestSubsequencesDifference {

    public static int LongestSubsequencesDiffer(int arr[]) {
        int maxLength = 0;

        if (arr.length == 0) {
            return 0;
        }

        // Initialize dp array where each element is a subsequence of length 1
        int dp[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;// Every element is a subsequence of length 1
        }

        // Fill the dp array
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The longest subsequence will be the maximum value in the dp array
        for (int i = 0; i < arr.length; i++) {
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    public static int LongestSubsequencesDifferBinarySearch(int arr[]) {
        int maxLength = 0;

        // Map to store the longest subsequence ending at each element. Like a filling
        // the dp table.
        Map<Integer, Integer> dp = new HashMap<>();

        // Loop through each number in the array
        for (int nums : arr) {

            // Find the length of the sequences we can extend.
            int length = 1;

            // If a sequence ends at a nums - 1, we can extend it to include nums.
            if (dp.containsKey(nums - 1)) {
                length = Math.max(length, dp.get(nums - 1) + 1);
            }

            // If a sequence ends at nums + 1, we can extend it to include nums.
            if (dp.containsKey(nums + 1)) {
                length = Math.max(length, dp.get(nums + 1) + 1);
            }

            // Store the longest subsequences length ending at nums.
            dp.put(nums, length);

            // Update the global maximum length
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };

        System.out.println(LongestSubsequencesDifferBinarySearch(arr));

    }
}
