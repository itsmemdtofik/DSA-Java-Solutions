package GoldManSachs.Easy;

public class isPerfectSquareRoot {
    public static boolean isPerfectSquare(int num) {

        // Checking the negative integer
        if (num < 0) {
            return false;
        }

        // Calculating the square of the number.
        int sqrt = (int) Math.sqrt(num);

        // Check if square of the integer part of the square root equals to the number.
        return sqrt * sqrt == num;
    }

    // Function to check if a number is a perfect square using binary search
    public static boolean isPerfectSquareBinary(int num) {
        if (num < 0)
            return false; // Negative numbers can't be perfect squares

        int left = 0, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid; // Use long to prevent overflow

            if (midSquared == num) {
                return true; // Found the perfect square
            } else if (midSquared < num) {
                left = mid + 1; // Narrow search to the right half
            } else {
                right = mid - 1; // Narrow search to the left half
            }
        }

        return false; // No perfect square found
    }

    // Function to count perfect squares in the array using binary search
    public static int countPerfectSquares(int[] arr) {
        int count = 0;

        // Iterate through each element in the array
        for (int num : arr) {
            if (isPerfectSquare(num)) {
                count++; // Increment the count if the number is a perfect square
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example array of integers
        int[] arr = { 4, 9, 16, 20, 25, 26 };

        // Check if elements are perfect squares
        for (int num : arr) {
            if (isPerfectSquare(num)) {
                System.out.println(num + " is a perfect square.");
            } else {
                System.out.println(num + " is not a perfect square.");
            }
        }

        System.out.println("The Perfect Square are in the array : " + countPerfectSquares(arr));
    }
}
