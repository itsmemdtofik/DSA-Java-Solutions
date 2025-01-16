package GoldManSachs.Easy;

public class RunLengthEncoding {
    public static String rle(String input) {
        // Edge case: if the input is empty, return an empty string
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        // StringBuilder to build the result
        StringBuilder encoded = new StringBuilder();
        
        int count = 1; // Initialize count for the first character
        
        // Iterate over the string starting from the second character
        for (int i = 1; i < input.length(); i++) {
            // If the current character is the same as the previous one, increment the count
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // Otherwise, append the character and its count to the result
                encoded.append(input.charAt(i - 1)).append(count);
                count = 1; // Reset count for the new character
            }
        }
        
        // Append the last character and its count
        encoded.append(input.charAt(input.length() - 1)).append(count);
        
        return encoded.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(rle("a"));        // a1
        System.out.println(rle("aa"));       // a2
        System.out.println(rle("aabbb"));    // a2b3
        System.out.println(rle("aabbbaa"));  // a2b3a2
    }
}
