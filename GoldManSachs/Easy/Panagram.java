package GoldManSachs.Easy;

import java.util.*;

/**
 * A pangram (or holoalphabetic sentence) is a sentence that contains every letter of the alphabet at least once.

For example:

"The quick brown fox jumps over the lazy dog" is a pangram because it contains all 26 letters of the English alphabet, from 'a' to 'z'.
"Pack my box with five dozen liquor jugs" is another example of a pangram.
Note: A pangram can be of any length, but it must include all 26 letters of the alphabet.

 * */

public class Panagram {
    // Global alphabet constant
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String findMissingCharacters(String sentence) {
        // If the sentence is empty, return all characters
        if (sentence == null || sentence.isEmpty()) {
            return ALPHABET;
        }

        // Convert sentence to lowercase and remove non-alphabet characters
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");

        // Use a HashSet to track the characters in the sentence
        HashSet<Character> sentenceSet = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            sentenceSet.add(c);
        }

        // Find missing characters
        StringBuilder missingChars = new StringBuilder();
        for (char c : ALPHABET.toCharArray()) {
            if (!sentenceSet.contains(c)) {
                missingChars.append(c);
            }
        }

        return missingChars.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findMissingCharacters("The quic brown for jumps over the lazy dog")); // Output: "kx"
        System.out.println(findMissingCharacters("")); // Output: "abcdefghijklmnopqrstuvwxyz"
        System.out.println(findMissingCharacters("The quick brown fox jumps over the lazy dog")); // Output: ""
        System.out.println(findMissingCharacters("Pack my box with five dozen liquor jugs"));
        System.out.println(findMissingCharacters("Waltz, nymph, for quick jigs vex Bud."));
        System.out.println(findMissingCharacters("Sphinx of black quartz, judge my vow."));
            }
}
