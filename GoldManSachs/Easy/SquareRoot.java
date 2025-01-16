package GoldManSachs.Easy;

public class SquareRoot {

    /**
     * Java program to find the square root of given integer using a loop.
     * Time complexity O(n) space O(1)
     */
    public static int squareInteger(int num) {

        int res = 1;
        while (res * res <= num) {
            res++;
        }

        return res - 1;
    }

    /**
     * Finding quare root of an integer using the binary search.
     * Time complexity = O(log n)
     * Space complexity = O(1)
     */
    public static int squareRootIntegerUsingBinarySearch(int num) {

        // Initial search space.
        int low = 1;
        int high = num;
        int res = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If square of mid is less than or equal to num update the result and search in
            // upper half.
            if (mid * mid <= num) {
                res = mid;
                low = mid + 1;
            } else {// If square of mid exceeds num, search in the lower half
                high = mid - 1;
            }

        }
        return res;
    }

    /**
     * Calculate the square root using the mathmetical formula.
     * Time complexity = O(1)
     * Space complexity = O(1)
     */

    public static int floorSquareRoot(int num) {

        int res = (int) Math.exp(0.5 * Math.log(num));

        // If square of res + 1 is less than or equal to num.
        if ((res + 1) * (res + 1) <= num) {
            res++;
        }
        return res;
    }

    public static int[] findSquareRootInArr(int arr[]) {

        int[] squareRoots = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Check if the number is a perfect square
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                squareRoots[i] = sqrt; // Store the square root if it's a perfect square
            } else {
                squareRoots[i] = -1; // Use -1 to indicate no perfect square
            }
        }

        return squareRoots;
    }

    /**
     * *SquareRootWithPrecision
     * 
     * @param N
     * @param P
     * @return
     */
    public static double SquareRootWithPrecision(int N, double P) {
        double low = 0, high = N;
        double mid = 0;

        while (high - low > P) {
            mid = low + (high - low) / 2;
            if (mid * mid > N) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return mid; // mid will be within the precision P
    }

    public static void main(String[] args) {
        // Example array of integers
        int[] arr = { 4, 9, 16, 20, 25, 26 };

        // Call the method to find square roots
        int[] squareRoots = findSquareRootInArr(arr);

        // Print the result
        for (int i = 0; i < squareRoots.length; i++) {
            if (squareRoots[i] != -1) {
                System.out.println("Square root of " + arr[i] + " is: " + squareRoots[i]);
            } else {
                System.out.println("No perfect square root for: " + arr[i]);
            }
        }

        int N = 11;
        double P = 0.001;

        double result = SquareRootWithPrecision(N, P);
        System.out.printf("Square root of %d with precision %.3f is %.3f%n", N, P, result);

    }

}
