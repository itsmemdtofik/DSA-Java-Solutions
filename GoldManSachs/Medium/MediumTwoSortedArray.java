package GoldManSachs.Medium;

public class MediumTwoSortedArray {

    public static int[] mergeArray(int[] arr1, int arr2[]) {

        int n = arr1.length;
        int m = arr2.length;

        int merged[] = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }

        while (j < m) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int merged[] = mergeArray(nums1, nums2);

        int n = merged.length;

        if (n % 2 == 1) {
            return (double) merged[(n / 2)];
        } else {
            return (double) (merged[(n / 2) - 1] + merged[(n / 2)]) / 2;
        }

    }

    public static double AnotherfindMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2; // Partition index for nums1
            int j = (m + n + 1) / 2 - i; // Partition index for nums2, based on i

            // Edge cases: handle i = 0 or i = m
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the total length is odd, return the max of the left side
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                // If the total length is even, return the average of the two middle values
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            } else if (maxLeft1 > minRight2) {
                // Move the partition in nums1 to the left
                high = i - 1;
            } else {
                // Move the partition in nums1 to the right
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);

        int[] nums3 = { 1, 2 };
        int[] nums4 = { 3, 4 };

        median = findMedianSortedArrays(nums3, nums4);
        System.out.println("The median is: " + median);
    }
}
