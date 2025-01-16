package GoldManSachs.Easy;

import java.util.HashMap;

public class FirstNonRepeating {
    public int firstUniqChar(String s) {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // Step 3: If no non-repeating character exists, return -1
        return -1;
    }

    // Example Usage
    public static void main(String[] args) {
        FirstNonRepeating solution = new FirstNonRepeating();
        System.out.println(
                "First Non-Repeating or Unique character \"leetcode\" is : " + solution.firstUniqChar("leetcode"));
        System.out.println(
                "First Non-Repeating or Unique character \"loveleetcode\" is : " + solution.firstUniqChar("loveleetcode"));
        System.out
                .println("First Non-Repeating or Unique character \"aabb\" is : " + solution.firstUniqChar("aabb"));
    }

}
