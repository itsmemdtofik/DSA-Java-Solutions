package GoldManSachs.Easy;

/*
 * *Longes Uniform Substring Or longest repeated substring.
 */
import java.util.*;
public class LongestUniformSubstring {

    public int[] repeatedSubstring(String s) {
        if (s.length() == 0)
            return new int[] { -1, 0 };
        if (s.length() == 1)
            return new int[] { 0, 1 };
        int idx = -1;
        int maxCharCount = 0;
        int count = 1;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > maxCharCount) {
                    maxCharCount = count;
                    idx = i - count;
                }
                count = 1;
            }
        }
        if (count > maxCharCount) {
            maxCharCount = count;
            idx = i - count;
        }
        return new int[] { idx, maxCharCount };
    }

    public static void main(String[] args) {
        LongestUniformSubstring obj = new LongestUniformSubstring();

        // Test cases
        String s1 = "10000111";
        String s2 = "aabbbbbCdAA";
        String s3 = "abbbccda";

        // Print the results
        System.out.println("For input \"" + s1 + "\", the longest uniform substring is at index: " +Arrays.toString(obj.repeatedSubstring(s1)));
        System.out.println("For input \"" + s2 + "\", the longest uniform substring is at index: " + Arrays.toString(obj.repeatedSubstring(s2)));
        System.out.println("For input \"" + s3 + "\", the longest uniform substring is at index: " +Arrays.toString(obj.repeatedSubstring(s3)));
    }
}
