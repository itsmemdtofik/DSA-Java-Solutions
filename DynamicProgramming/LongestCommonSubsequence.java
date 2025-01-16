package DynamicProgramming;

import java.lang.Math;

public class LongestCommonSubsequence {

    public static int LCS(String str1, String str2, int dp[][]) {

        dp = new int[str1.length() + 1][str2.length() + 1];

        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    System.out.print(dp[i][j] + ", ");
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static int LCSRecursive(String str1, String str2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + LCSRecursive(str1, str2, m - 1, n - 1);

        else
            return Math.max(LCSRecursive(str1, str2, m, n - 1), LCSRecursive(str1, str2, m - 1, n));

    }

    public static void main(String[] args) {

        String str1 = "AAGTAB";
        String str2 = "GXTXAYB";
        //String str1 = "ABCBDAB";
        //String str2 = "BDCAB";
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[str1.length()][str2.length()];

        System.out.println("The length of the LCS: " + LCSRecursive(str1, str2, m, n));
    }

}