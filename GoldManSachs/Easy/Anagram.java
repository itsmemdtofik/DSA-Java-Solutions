/**
 * !Anagagram String
 * Question: Check whether a given string is anagram or not.
 */

package GoldManSachs.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    // Method to check if two strings are anagrams
    public static boolean AnagramChecker(String str1, String str2) {
        // If the lengths of the strings are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to lowercase to make the check case-insensitive
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
        
    }
    
    // Optimized method to check if two strings are anagrams using frequency count
    public static boolean areAnagrams(String str1, String str2) {
        // If the lengths of the strings are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Create a frequency array for the 26 lowercase English letters
        int[] charCount = new int[26];

        // Count the frequency of each character in str1
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Subtract the frequency for each character in str2
        for (char c : str2.toCharArray()) {
            charCount[c - 'a']--;
        }

        // If any value in the charCount array is not zero, the strings are not anagrams
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams
        return true;
    }

    public static boolean areAnagramsUsingMap(String str1, String str2) {
        // If lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a frequency map for the first string
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        // Reduce the frequency map using the second string
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        return true;        
    
    }

    public static void main(String[] args) {
        // Example 1: "listen" and "silent"
        System.out.println("Are 'listen' and 'silent' anagrams? " + AnagramChecker("listen", "silent"));

        // Example 2: "evil" and "vile"
        System.out.println("Are 'evil' and 'vile' anagrams? " + AnagramChecker("evil", "vile"));

        // Example 3: "triangle" and "integral"
        System.out.println("Are 'triangle' and 'integral' anagrams? " + AnagramChecker("triangle", "integral"));

        // Example 4: "hello" and "world"
        System.out.println("Are 'hello' and 'world' anagrams? " + AnagramChecker("hello", "world"));

        // Example 5: "dusty" and "study"
        System.out.println("Are 'dusty' and 'study' anagrams? " + AnagramChecker("dusty", "study"));
    }
}
