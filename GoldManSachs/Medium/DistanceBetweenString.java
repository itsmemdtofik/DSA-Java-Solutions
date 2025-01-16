/**
 * !Distance between two strings.
 * 
 * * There are two approaches:
 * ? 1.Hamming Distacne:
 * Definition: The number of positions at which the corresponding characters 
 * in the two strings are different. This method can only be applied to strings 
 * of equal length.
 * 
 * Example:
 * Strings: "karolin" and "kathrin"
 * Hamming Distance = 3 (The positions 3, 4, and 5 differ).
 * 
 * ? Levenshtein Distance:
 * Definition: The minimum number of insertions, deletions, or substitutions 
 * required to convert one string into another.
 * 
 * Example:
 * Strings: "kitten" and "sitting"
 * 1. Substituet 'k' -> 's' -> 1
 * 2. Substitute 'e' -> 'i' -> 1
 * 3. Add        'g' -> to the end -> 1
 * Result = 3.
 * Levenshtein Distance = 3 (substitute 'k' with 's', substitute 'e' with 'i', and append 'g').
 */

package GoldManSachs.Medium;

public class DistanceBetweenString {

    public static class HammingDistance {
        public static int findDistance(String str1, String str2) throws IllegalArgumentException {
            // Step 1: Check if strings are of equal length
            if (str1.length() != str2.length()) {
                throw new IllegalArgumentException("Strings must be of equal length");
            }

            // Step 2: Initialize a counter for mismatches
            int distance = 0;

            // Step 3: Compare characters at each position
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    distance++; // Increment mismatch counter
                }
            }

            // Step 4: Return the total mismatch count
            return distance;
        }

    }

    public static class LevenshteinDistance {
        public static int findDistance(String str1, String str2) {
            // Step 1: Get lengths of both strings
            int len1 = str1.length();
            int len2 = str2.length();

            // Step 2: Initialize a 2D matrix to store distances
            int[][] dp = new int[len1 + 1][len2 + 1];

            // Step 3: Fill the first row and column with base cases
            // Cost of converting empty string to the current length of the other string
            for (int i = 0; i <= len1; i++) {
                dp[i][0] = i; // Deletion cost
            }
            for (int j = 0; j <= len2; j++) {
                dp[0][j] = j; // Insertion cost
            }

            // Step 4: Fill the rest of the matrix
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    // Check if the characters are the same
                    int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;

                    // Find the minimum cost among:
                    // (a) Insertion, (b) Deletion, (c) Substitution
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, // Deletion
                                    dp[i][j - 1] + 1), // Insertion
                            dp[i - 1][j - 1] + cost // Substitution
                    );
                }
            }

            // Step 5: Return the value in the bottom-right corner of the matrix
            return dp[len1][len2];
        }

    }

    public static void main(String[] args) {

        String str1 = "ab";
        String str2 = "abc";

        // Step 5: Call the function and print the result
        try {
            int result = LevenshteinDistance.findDistance(str1, str2);
            System.out.println("Levenshtein Distance: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        String str3 = "karolin";
        String str4 = "kathrin";

        // Step 6: Call the function and print the result
        try {
            int result = HammingDistance.findDistance(str3, str4);
            System.out.println("Hamming Distance : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
