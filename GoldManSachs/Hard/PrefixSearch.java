/**
 * *Prefix Search
 * 
 * Provide an implementation of the findAll() method to in MyPrefixSearch.
 * Describing any trade-off arising from your implementation.
 * findAll() -> Returns a list of all location in a document where the (case-insensitive)
 * words begins with the given prefix.
 * 
 * *Example: Given the document = "a aa Aaa abca bca"
 * 
 * 1. findAll("a") -> [0, 2, 5, 6]
 * 2. findAll("bc") -> [14]
 * 3. findAll(aA) -> [2, 5]
 * 4. findAll(abc) -> [9]
 * 
 * Time complexity:
 * split("\\+s") -> O(n)
 * word.toLowerCase().startsWith(prefix.toLowerCase()) -> O(m)
 * 
 * Over All : O(w * m)
 */

package GoldManSachs.Hard;

import java.util.ArrayList;
import java.util.List;

public class PrefixSearch {
    String document;

    // Constructor to initialize the document
    PrefixSearch(String document) {
        this.document = document;
    }

    // Method to find all locations where words start with the given prefix
    // (case-insensitive)
    public List<Integer> findAll(String prefix) {

        List<Integer> result = new ArrayList<Integer>();

        if (prefix == null || prefix.isEmpty() || document == null || document.isEmpty()) {
            return result; // Return an empty list if input is invalid
        }

        // Split the document into words using space as the delimiter
        document = document.trim();
        String[] words = document.split(" ");

        int position = 0; // Keeps track of the position of each word in the document
        for (String word : words) {
            // Check if the word (case-insensitive) starts with the given prefix
            if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
                result.add(position); // Add the starting index of the word
            }
            position += word.length() + 1; // Update position to the next word (including space)
        }

        return result;
    }

    /**
     * !Optimized Solution:
     * 
     * * Using a Trie (Prefix Tree):
     * Instead of checking every word in the document, you can use a Trie (a prefix
     * tree) to store all the words in the document. A Trie allows you to
     * efficiently find all words that start with a given prefix in O(P) time where
     * P is the length of the prefix (not the entire word length). This is because a
     * Trie allows prefix-based searches in constant time for each character of the
     * prefix.
     * 
     * Solution using Trie:
     * Step 1: Build the Trie with the words from the document.
     * Step 2: Perform a search on the Trie to get all words starting with the given prefix.
     * 
     * Time Complexity:
     * Building the Trie takes O(n) where n is the length of the document.
     * Searching for all words starting with a given prefix takes O(P + k), where P
     * is the length of the prefix and k is the number of words that match the
     * prefix.
     * 
     * @param args
     */

    public static void main(String[] args) {
        PrefixSearch search = new PrefixSearch(" a aa Aaa abca bca ");
        System.out.println(search.findAll("a")); // Output: [0, 2, 5, 10]
    }
}
