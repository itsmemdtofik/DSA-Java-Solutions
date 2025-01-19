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

    public static void main(String[] args) {

        int[] nums1 = { 1,2, 2 };
        int[] nums2 = { 3,4,4 };

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);

        int[] nums3 = { 1, 2 };
        int[] nums4 = { 3, 4 };

        median = findMedianSortedArrays(nums3, nums4);
        System.out.println("The median is: " + median);
    }
}
