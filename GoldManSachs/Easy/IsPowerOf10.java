package GoldManSachs.Easy;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n ==
 * 3x.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * Example 2:
 * 
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * Example 3:
 * 
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 */

public class IsPowerOf10 {
	// Method to calculate the largest power of given base within integer limits.
	public static int largestPower(int base) {
		int maxInteger = Integer.MAX_VALUE; // 2^31-1
		int power = 1;
		while (power <= maxInteger / base) { // prevent overflow
			power = power * base;
		}
		return power;

	}

	// Method to check if a number is a power of the given base.
	public static boolean isPowerOfBase(int num, int base) {
		// Base must be greater than 1 and must be positive
		if (num <= 0 || base <= 1) {
			return false;
		}

		// Dynamically calculate the largest power.
		int largestPower = largestPower(base);
		// Check if number divide the largest power.
		return largestPower % num == 0;
	}

	// One line code for all the power of 3, 4, 5, 10 etc.
	public static boolean powerOfAllNumber(int num) {
		int result = (int) Math.pow(3, 19);
		return (num > 0 && result % num == 0);
	}

	public static void main(String[] args) {
		// Check for power of 3
		System.out.println(isPowerOfBase(27, 3)); // Output: true
		System.out.println(isPowerOfBase(0, 3)); // Output: false
		System.out.println(isPowerOfBase(-1, 3)); // Output: false

		// Check for power of 10
		System.out.println(isPowerOfBase(10, 10)); // Output: true
		System.out.println(isPowerOfBase(100, 10)); // Output: true
		System.out.println(isPowerOfBase(3, 10)); // Output: false
	}
}
