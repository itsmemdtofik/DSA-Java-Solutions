package GoldManSachs.Easy;

/**
 * 
 * 
 * Example 1: reverse the character
 * 
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 1: (reverse the words of string )
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 3: Reverse the entire string
 * Input: "abcdefgh"
 * ouput: "hgfedcba"
 * 
 * 
 */
public class ReverseStringBug {

    public static String reverseCharacter(char arr[]) {

        int left = 0;
        int right = arr.length - 1;

        // Reverse the character array in place
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // Build the output in the desired format
        StringBuilder addDoubleComma = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            addDoubleComma.append("\"").append(arr[i]).append("\"");
            if(i < arr.length - 1){
                addDoubleComma.append(",");
            }
        }
        return addDoubleComma.toString();

    }

    public static String reverseWordsOfString(String str) {

        // Remove leading and trailing space
        str = str.trim();

        // Split by one more spaces
        String strArr[] = str.split("\\s+");

        StringBuilder reversBuilder = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            reversBuilder.append(strArr[i]);
            if (i > 2) {
                reversBuilder.append(" ");
            }
        }

        return reversBuilder.toString();
    }

    public static String reverseString(String str) {

        String revString = "";
        str = str.trim();

        for (int i = str.length() - 1; i >= 0; i--) {
            revString = revString + str.charAt(i);
        }

        return revString;
    }

    public static void main(String[] args) {

        System.out.println(reverseCharacter(new char[] { 'h', 'e', 'l', 'l', 'o' }));
        System.out.println("Reverses words are : " + reverseWordsOfString(" the sky is blue"));
        System.out.println("Reverse String is : " + reverseString("abcdefgh"));
    }
}
