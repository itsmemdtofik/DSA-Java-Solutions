/**
 * *Largest Word Match
 * 
 * Given a dictionary of the words(strings) which contains different words & you
 * are given an input string e.g. “abd”. You need to find the largest word
 * available in the supplied dictionary which can be made using the letters of
 * input string. The returned word can contain only the same no of occurrences
 * of the letters as given in the input string i.e. if a letter is given once
 * then in the output it should be existed only once.
 * 
 * Examples:
 * 
 * Dictionary {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”}.
 * 
 * input string is: “eot”.
 * Output: should be “toe”.
 * 
 * input string is “ogtdes”. and
 * Output: is “dogs” and “toes”.
 *
 * 
 */

/**
 * 
 * !Code Flow
 * *Here’s what the program does:
 * 
 * Create a frequency map for the input string.
 * For each word in the dictionary:
 * Create its frequency map.
 * Check if the word can be formed using the input's letters.
 * Track the longest word(s) that can be formed.
 * Print the result.
 */

/**
 * Example Walkthrough
 * Example 1
 * 
 * Dictionary: {"to", "banana", "toe", "dogs", "ababcd", "elephant"} Input:
 * "eot"
 * 
 * Input frequency map: {e: 1, o: 1, t: 1}
 * Check each word:
 * "to" → {t: 1, o: 1} ✅ Can form.
 * "toe" → {t: 1, o: 1, e: 1} ✅ Can form.
 * "banana" → {b: 1, a: 3, n: 2} ❌ Cannot form.
 * "dogs" → {d: 1, o: 1, g: 1, s: 1} ❌ Cannot form.
 * "ababcd" → {a: 2, b: 2, c: 1, d: 1} ❌ Cannot form.
 * "elephant" → {e: 2, l: 1, p: 1, h: 1, a: 1, n: 1, t: 1} ❌ Cannot form.
 * Result: "toe" is the longest word that can be formed.
 */
package GoldManSachs.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestWordMatch {

    /**
     * *Step1: Create a frequency map for input string
     * 
     * @param str
     * @return
     */
    private static Map<Character, Integer> createFrequencyMap(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    /**
     * *Step2: Create a frequency map for word and check the if it can form the
     * word.
     * 
     * @param word
     * @param inputFrequencyMap
     * @return
     */
    private static boolean canFormWord(String word, Map<Character, Integer> inputFrequencyMap) {
        Map<Character, Integer> wordFrequencyMap = createFrequencyMap(word);

        for (Map.Entry<Character, Integer> entry : wordFrequencyMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (inputFrequencyMap.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }

    /**
     * *Step3: Track the longest words that can be formed.
     * 
     * @param dictionary
     * @param input
     * @return
     */
    public static List<String> findLargestWords(Set<String> dictionary, String input) {
        List<String> result = new ArrayList<>();
        int maxLength = 0;

        // Create a frequency map of characters in the input string
        Map<Character, Integer> inputFrequencyMap = createFrequencyMap(input);

        for (String word : dictionary) {
            if (canFormWord(word, inputFrequencyMap)) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    result.clear(); // Clear the previous shorter words
                    result.add(word);
                } else if (word.length() == maxLength) {
                    result.add(word); // Add word of the same max length
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("to", "banana", "toe", "dogs", "ababcd", "elephant"));

        // Example 1
        String input1 = "eot";
        List<String> result1 = findLargestWords(dictionary, input1);
        System.out.println("Input: " + input1 + ", Output: " + result1);

        // Example 2
        String input2 = "ogtdes";
        List<String> result2 = findLargestWords(dictionary, input2);
        System.out.println("Input: " + input2 + ", Output: " + result2);
    }
}
