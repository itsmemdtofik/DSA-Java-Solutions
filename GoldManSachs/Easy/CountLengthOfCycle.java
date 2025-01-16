package GoldManSachs.Easy;

import java.util.*;

public class CountLengthOfCycle {
    public static int lengthOfCycle(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        HashMap<Integer, Integer> visited = new HashMap<>(); // Maps index -> step number
        int currentIndex = startIndex;
        int step = 0;
        int lengthOfCycle = 0;

        for (; currentIndex < arr.length; step++) {
            if (visited.containsKey(currentIndex)) {
                // Cycle detected; calculate length
                lengthOfCycle = step - visited.get(currentIndex);
                return lengthOfCycle;
            }
            visited.put(currentIndex, step); // Mark the current index with the step number
            currentIndex = arr[currentIndex]; // Move to the next index
        }

        // If we exit the loop, there's no cycle
        return -1;
    }

    // Floyed Warshal Cycle Algorithm(Hare and Tortoise)
    public static int lengthCycle(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        // Tortoise and Hare approach to detect the cycle
        int slow = startIndex;
        int fast = startIndex;

        // Move slow by 1 step and fast by 2 steps until they meet or fast reaches the
        // end
        while (fast < arr.length && arr[fast] < arr.length) {
            slow = arr[slow]; // Move slow by 1 step
            fast = arr[arr[fast]]; // Move fast by 2 steps

            if (slow == fast) {
                // Cycle detected, calculate the cycle length
                int cycleLength = 0;
                do {
                    slow = arr[slow];
                    cycleLength++;
                } while (slow != fast);
                return cycleLength;
            }
        }

        // No cycle detected
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfCycle(new int[] { 1, 0 }, 0)); // 2
        System.out.println(lengthOfCycle(new int[] { 1, 2, 0 }, 0)); // 3
        System.out.println(lengthOfCycle(new int[] { 1, 2, 3, 1 }, 0)); // 3

        System.out.println("Using Floyd's Tortoise and Hare : " + lengthCycle(new int[] { 1, 0 }, 0)); // 2
        System.out.println("Using Floyd's Tortoise and Hare : " + lengthCycle(new int[] { 1, 2, 0 }, 0)); // 3
        System.out.println("Using Floyd's Tortoise and Hare : " + lengthCycle(new int[] { 1, 2, 3, 1 }, 0)); // 3

    }
}
