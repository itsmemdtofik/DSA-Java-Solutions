/**
 * !Snow Pack or Trapping rain water.
 * 
 * Given an array of non-negative integers representing the elevations from the 
 * vertical cross section of the range of hills, determine how many units of snow 
 * could be captured between the hills.
 * 
 * 
 * For example: ({0, 1, 3}, {0, 1,2},{0,4,2},{0,3,0})
 * Implement: Find the amount of snow that could be captured.
 */

package GoldManSachs.Medium;

public class SnowPack {

    public static int computeSnowpack(int arr[]) {
        if (arr == null || arr.length < 3) {
            // Less than 3 elements can not trap the snow
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int snow = 0;

        while (leftHeight < rightHeight) {
            if (arr[leftHeight] < arr[rightHeight]) {
                if (arr[leftHeight] >= leftMax) {
                    // Update the left maximum
                    leftMax = arr[leftHeight];
                } else {
                    snow = snow + leftMax - arr[leftHeight];
                }
                leftHeight++;
            } else {
                if (arr[rightHeight] >= rightMax) {
                    // Update the right maximum
                    rightMax = arr[rightHeight];
                } else {
                    snow = snow + rightMax - arr[rightHeight];
                }
                rightHeight--;
            }
        }

        return snow;

    }

    public static void main(String[] args) {
        int[] elevations = { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 };
        System.out.println("Snow captured: " + computeSnowpack(elevations) + " units");
    }
}

/**
 * Steps:
 * 
 * Step-by-Step Example
 * For the input {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}:
 * 
 * Initial state:
 * left = 0, right = 11, leftMax = 0, rightMax = 0, snow = 0
 * Iteration 1:
 * 
 * Compare arr[left] = 0 with arr[right] = 0.
 * Since arr[left] < arr[right]:
 * Update leftMax = 0 (no snow captured).
 * Move left to 1.
 * Iteration 2:
 * 
 * Compare arr[left] = 1 with arr[right] = 0.
 * Since arr[right] <= arr[left]:
 * Update rightMax = 0 (no snow captured).
 * Move right to 10.
 * Iteration 3:
 * 
 * Compare arr[left] = 1 with arr[right] = 3.
 * Since arr[left] < arr[right]:
 * Update leftMax = 1 (no snow captured).
 * Move left to 2.
 * Iteration 4:
 * 
 * Compare arr[left] = 3 with arr[right] = 3.
 * Since arr[right] <= arr[left]:
 * Update rightMax = 3 (no snow captured).
 * Move right to 9.
 * Iteration 5:
 * 
 * Compare arr[left] = 3 with arr[right] = 0.
 * Since arr[right] <= arr[left]:
 * Snow trapped = rightMax - arr[right] = 3 - 0 = 3.
 * Add 3 to snow, making snow = 3.
 * Move right to 8.
 * ...and so on.
 */