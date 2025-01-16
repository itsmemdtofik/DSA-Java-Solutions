package GoldManSachs.Medium;

public class StringToInteger {

    /**
     * Convert a string to an integer. Handles leading/trailing spaces, signs, and
     * valid numeric characters.
     */
    public static int atoi(String string) {
        if (string == null || string.isEmpty()) {
            return 0; // Return 0 for null or empty strings
        }

        int result = 0, index = 0, sign = 1;
        string = string.trim();
        string = string.toLowerCase();
        int n = string.length();

        // Handle optional sign
        if (index < n && (string.charAt(index) == '+' || string.charAt(index) == '-')) {
            sign = (string.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert digits to integer
        while (index < n) {
            char c = string.charAt(index);
            if (c < '0' || c > '9') {
                break; // Stop at the first non-numeric character
            }
            int digit = c - '0';

            // Check for integer overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    /**
     * Tests the atoi implementation.
     */
    public static boolean doTestPass() {
        boolean result = true;

        // Basic tests
        result = result && (atoi("42") == 42);
        result = result && (atoi("   -42") == -42);
        result = result && (atoi("4193 with words") == 4193);
        result = result && (atoi("Awords and 987") == 0);
        result = result && (atoi("-91283472332") == Integer.MIN_VALUE);
        result = result && (atoi("2147483648") == Integer.MAX_VALUE);

        // Edge cases
        result = result && (atoi("") == 0); // Should throw exception, change test based on preference
        result = result && (atoi("000123") == 123);

        return result;
    }

    public static void main(String[] args) {
        if (doTestPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Some tests fail");
        }
    }
}